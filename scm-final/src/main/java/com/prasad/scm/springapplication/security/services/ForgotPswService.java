package com.prasad.scm.springapplication.security.services;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import com.prasad.scm.springapplication.models.User;
import com.prasad.scm.springapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForgotPswService {
    private static final long EXPIRE_TOKEN_AFTER_MINUTES = 30;

    @Autowired
    private UserRepository userRepo;

    /**
     * Initiates the process of password recovery for a user.
     *
     * @param email User's email
     * @return A string indicating the result of the password recovery process
     */
    public String forgotPassword(String email) {
        Optional<User> userOptional = userRepo.findByEmail(email);

        if (userOptional.isEmpty()) {
            return "Invalid email id.";
        }

        User user = userOptional.get();
        user.setToken(generateToken());
        user.setTokenCreationDate(LocalDateTime.now());

        user = userRepo.save(user);

        return user.getToken();
    }

    /**
     * Resets the password for a user.
     *
     * @param token    Password reset token
     * @param password New password
     * @return A string indicating the result of the password reset process
     */
    public String resetPassword(String token, String password) {
        User userOptional = userRepo.findByToken(token);

        if (userOptional == null) {
            return "Invalid token.";
        }

        LocalDateTime tokenCreationDate = userOptional.getTokenCreationDate();

        if (isTokenExpired(tokenCreationDate)) {
            return "Token expired.";
        }

        userOptional.setPassword(password);
        userOptional.setToken(null);
        userOptional.setTokenCreationDate(null);

        userRepo.save(userOptional);

        return "Your password has been successfully updated.";
    }

    /**
     * Generates a unique token for password recovery.
     *
     * @return The generated token
     */
    private String generateToken() {
        StringBuilder token = new StringBuilder();

        return token.append(UUID.randomUUID().toString()).append(UUID.randomUUID().toString()).toString();
    }

    /**
     * Checks if the password reset token is expired.
     *
     * @param tokenCreationDate The creation date of the token
     * @return true if the token is expired, false otherwise
     */
    private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {
        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(tokenCreationDate, now);

        return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
    }
}
