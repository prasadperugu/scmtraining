package com.prasad.scm.springapplication.kafka.controllers;

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
    private JavaMailSender mailSender;

    public void sendEmail(String email, String token  ) throws MessagingException, UnsupportedEncodingException
    {
        System.out.println(token);
        //Code for Sending OTP to the respected user email id.
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("scmsupport@exafluece.com", "SCMXPertLite Support");
        helper.setTo(email);
        String subject = "Password Changed Confirmation From SCMXPertLite Support";
        String content = "<html>"

//	+"<body><p> hello world</p><a href='http://3.16.14.127:80/Resetpassword.html?"+token+"'> click here</a></body>"
                +"<body><p> hello world</p><a href='http://127.0.0.1:3000/scm-final-ui/ResetPassword.html?"+token+"'> click here</a></body>"
                + "</html>";

        helper.setSubject(subject); //Setting Subject to email
        helper.setText(content, true); //Sending Email as text/html format
        mailSender.send(message); //Sending email to the User email id.
    }

}