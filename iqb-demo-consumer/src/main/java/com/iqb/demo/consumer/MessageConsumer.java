package com.iqb.demo.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
	
	@Autowired
	MessageFormatter formatter;
	
	public void handleMessage(String message) {
		if (isValidMessage(message)) {
			System.out.println(formatter.format(message));
		}
		else {
			System.out.println("Invalid message received: " + message);
		}
	}
	
	public boolean  isValidMessage(String in) {
		return in.contains(",");
	}

}