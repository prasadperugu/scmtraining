package com.prasad.scm.springapplication;



import com.prasad.scm.springapplication.kafka.producer.SendMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class SpringapplicationApplication {

    public static void main(String[] args) throws IOException {
        ApplicationContext context =SpringApplication.run(SpringapplicationApplication.class, args);
        SendMessage send =context.getBean(SendMessage.class);
        send.sendMessageToTopic();
    }

}
