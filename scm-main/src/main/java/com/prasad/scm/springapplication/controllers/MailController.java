package com.prasad.scm.springapplication.controllers;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailController {

    @Autowired
    private JavaMailSender mailSender; // JavaMailSender instance for sending emails

    /**
     * Send an email with the specified email address and token.
     *
     * @param email The recipient's email address.
     * @param token The token to include in the email.
     * @throws MessagingException           If an error occurs while creating or sending the email message.
     * @throws UnsupportedEncodingException If the email address or sender name has an unsupported encoding.
     */
    public void sendEmail(String email, String token) throws MessagingException, UnsupportedEncodingException {
        //Code for Sending OTP to the respective user email id.
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("scmsupport@exafluece.com", "SCMXPertLite Support");
        helper.setTo(email);
        String subject = "Password Changed Confirmation From SCMXPertLite Support";
        String content = "<html>"
                // URL for password reset page
                + "<body><p> hello world</p><a href='http://localhost:5500/Resetpassword.html?" + token + "'> click here</a></body>"
                + "</html>";

        helper.setSubject(subject); // Setting Subject for the email
        helper.setText(content, true); // Sending email as text/html format
        mailSender.send(message); // Sending email to the user's email address
    }

}
