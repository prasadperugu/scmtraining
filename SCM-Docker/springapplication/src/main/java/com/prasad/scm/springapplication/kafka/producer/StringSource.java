package com.prasad.scm.springapplication.kafka.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface StringSource {
	String OUTPUT = "streamdata";

    @Output(OUTPUT)
    MessageChannel output();
}
