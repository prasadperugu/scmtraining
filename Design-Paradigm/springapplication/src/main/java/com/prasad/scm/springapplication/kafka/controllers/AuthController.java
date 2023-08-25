package com.prasad.scm.springapplication.kafka.controllers;

import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.validation.Valid;

import com.prasad.scm.springapplication.models.ERole;
import com.prasad.scm.springapplication.models.Role;
import com.prasad.scm.springapplication.models.User;
import com.prasad.scm.springapplication.payload.request.ForgotPasswordRequest;
import com.prasad.scm.springapplication.payload.request.LoginRequest;
import com.prasad.scm.springapplication.payload.request.SignupRequest;
import com.prasad.scm.springapplication.payload.response.ForgotPasswordResponse;
import com.prasad.scm.springapplication.payload.response.JwtResponse;
import com.prasad.scm.springapplication.payload.response.MessageResponse;
import com.prasad.scm.springapplication.repository.RoleRepository;
import com.prasad.scm.springapplication.repository.UserRepository;
import com.prasad.scm.springapplication.security.jwt.JwtUtils;
import com.prasad.scm.springapplication.security.services.ForgotPswService;
import com.prasad.scm.springapplication.security.services.UserDetailsImpl;
import com.prasad.scm.springapplication.security.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * The AuthController class handles authentication and user-related operations.
 * It provides endpoints for user authentication, registration, and password management.
 * This class is responsible for processing incoming HTTP requests related to user authentication and registration,
 * interacting with the appropriate services, and returning the appropriate responses.
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    ForgotPswService forgotPswService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MongoTemplate mongoTemplate;

    //    @Autowired
//    MailController mailcontroller;
    @Autowired
    MailController mailController;

    /**
     * Authenticates a user.
     *
     * @param loginRequest Login request object containing email and password
     * @return ResponseEntity containing a JWT token and user details if authentication is successful, or an error message if authentication fails
     */
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtUtils.generateJwtToken(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());

            return ResponseEntity.status(HttpStatus.OK).body(new JwtResponse(
                    jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getEmail(),
                    roles
            ));

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user details.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred on the server.");
        }
    }

    /**
     * Registers a new user.
     *
     * @param signUpRequest Signup request object containing username, email, password, and roles
     * @return ResponseEntity containing a success message if registration is successful, or an error message if registration fails
     */
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        try {
            if (userRepository.existsByUsername(signUpRequest.getUsername())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new MessageResponse("Username is already taken!"));
            }

            if (userRepository.existsByEmail(signUpRequest.getEmail())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new MessageResponse("Email is already in use!"));
            }

            // Create new user's account
            User user = new User(
                    signUpRequest.getUsername(),
                    signUpRequest.getEmail(),
                    encoder.encode(signUpRequest.getPassword())
            );

            Set<String> strRoles = signUpRequest.getRoles();
            Set<Role> roles = new HashSet<>();

            if (strRoles == null) {
                Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Role is not found."));
                roles.add(userRole);
            } else {
                strRoles.forEach(role -> {
                    switch (role) {
                        case "admin":
                            Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                    .orElseThrow(() -> new RuntimeException("Role is not found."));
                            roles.add(adminRole);
                            break;
                        default:
                            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                    .orElseThrow(() -> new RuntimeException("Role is not found."));
                            roles.add(userRole);
                    }
                });
            }

            user.setRoles(roles);
            userRepository.save(user);

            // Returns a success message and sign-in details with status code 200
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse("User registered successfully!"));
        } catch (Exception e) {
            // Returns an error message with status code 400
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid user details!");
        }
    }

    /**
     * Initiates the process of password recovery for a user.
     *
     * @param email User's email
     * @return ResponseEntity containing a success message if the email is valid, or an error message if the email is invalid
     */
    @PostMapping("/forgot-password")
    public ResponseEntity<ForgotPasswordResponse> forgotPassword(@RequestParam(required = false) String email) {
        System.out.println(email);

        String response = forgotPswService.forgotPassword(email);

        // Check if the email is valid or invalid
        if (response.equals("Invalid email id.")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                mailController.sendEmail(email, response);
            } catch (UnsupportedEncodingException | MessagingException e) {
                // Returns an error as BAD_REQUEST message with status code 400
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            System.out.println(response);
            // Returns the success message with status code 200
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }


    @PostMapping("/reset-password")
    public ResponseEntity<ForgotPasswordRequest> resetPassword(@RequestParam(required = false) String token,
                                                               @RequestParam String password) {
        System.out.println(token);
        System.out.println(password);

        // Bycrypting the changed password
        String resetPassword = forgotPswService.resetPassword(token, bCryptPasswordEncoder.encode(password));

        if (resetPassword.equals("Invalid password.")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(resetPassword, HttpStatus.OK);
        }
    }

}

