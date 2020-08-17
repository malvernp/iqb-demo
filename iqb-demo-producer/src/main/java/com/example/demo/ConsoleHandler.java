package com.example.demo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.iqb.demo.commons.QueueConfigurations;

/**
 * entry point of service - handles requests from console and sends to a rabbit Q
 * @author m
 *
 */
@Component
public class ConsoleHandler implements CommandLineRunner {

	@Autowired
	private MessageSender messageSender;
	

	@Override
	public void run(String... args) throws Exception {
		try {
			messageSender.validateConnection();
			
			Scanner scanner = new Scanner(System.in);

			do {
				System.out.println("Enter a name: ");
				String line = scanner.nextLine();
				sendMessage(line);
			} while (true);

		} catch (Exception e) {
			System.out.println("RabbitMQ running? - also check application.properties");
			System.out.println(e.getMessage());
		}


	}


	private void sendMessage(String name) {
		String message = String.format("Hello my name is, %s", name);

		System.out.println("Sending message: " + message);

		messageSender.rabbitTemplate.convertAndSend(QueueConfigurations.DEMO_TOPIC, QueueConfigurations.DEMO_ROUTE_KEY, message);

	}

}