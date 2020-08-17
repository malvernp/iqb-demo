package com.iqb.demo.consumer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.iqb.demo.commons.QueueConfigurations;


@Component
public class TestSender {

	private final RabbitTemplate rabbitTemplate;

	public TestSender(MessageConsumer receiver, RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}

	public void send(String message) throws Exception {
		rabbitTemplate.convertAndSend(QueueConfigurations.DEMO_TOPIC, QueueConfigurations.DEMO_ROUTE_KEY,message);
	}

}