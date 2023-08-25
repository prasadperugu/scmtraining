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

    private String generateToken() {
        StringBuilder token = new StringBuilder();
        return token.append(UUID.randomUUID().toString()).append(UUID.randomUUID().toString()).toString();
    }

    private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {
        LocalDateTime now = LocalDateTime.now();
        Duration diff = Duration.between(tokenCreationDate, now);

        return diff.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
    }
}
