package com.prasad.scm.springapplication.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(StringSource.class)
public class StringProducer {
	@Autowired
    private StringSource stringSource;

    public void sendMessage(String message) {
        stringSource.output().send(MessageBuilder.withPayload(message).build());
    }
}
