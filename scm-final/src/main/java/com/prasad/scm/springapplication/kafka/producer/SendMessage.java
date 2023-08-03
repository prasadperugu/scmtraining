package com.prasad.scm.springapplication.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

@Component
@PropertySource("application.properties")
public class SendMessage
{
	private Socket socket;
	private BufferedReader input;

	@Value("${socket.host}")
	private String host;

	@Value("${socket.port}")
	private String port;

	@Autowired
	private StringProducer producer;

	public void sendMessageToTopic() throws NumberFormatException, UnknownHostException, IOException
	{
		System.out.println(host+"     "+port);
		socket = new Socket(host, Integer.parseInt(port));
		input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line = "";
		while (!line.equals("Over"))
		{
			try
			{
				line = input.readLine();
				producer.sendMessage(line);
			}
			catch(Exception exception)
			{
				System.out.println(exception);
				System.out.println("something went wrong");
			}
		}
	}
}
