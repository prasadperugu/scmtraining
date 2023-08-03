package com.prasad.scm.springapplication.kafka.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface StringSink {

	String INPUT = "streamdata";

	@Input(StringSink.INPUT)
	SubscribableChannel input();
}
