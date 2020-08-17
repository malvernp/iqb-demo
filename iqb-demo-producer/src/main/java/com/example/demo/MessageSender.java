package com.example.demo;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * handles sending of messages
 * @author m
 *
 */
@Component
public class MessageSender {
	
	public final RabbitTemplate rabbitTemplate;

	
	public MessageSender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	

	/**
	 * a health check to validate RabbitMQ up and running
	 * @throws Exception
	 */
	public void validateConnection() throws Exception {
		String info = this.rabbitTemplate
				.execute((channel) -> channel.getConnection().getServerProperties().get("version").toString());
		System.out.println("RabbitMQ Version: "  + info);

	}


}
