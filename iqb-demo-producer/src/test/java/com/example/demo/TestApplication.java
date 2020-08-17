package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest(properties = { "spring.rabbitmq.host=invalidhost123" })
public class TestApplication {

	@MockBean
	private ConsoleHandler consoleHandler;

	@Autowired
	private MessageSender messageSender;

	@Test
	public void test() throws Exception {
		try {
			messageSender.validateConnection();
			assertTrue(false, "Expect Connection to validate to fail");
		} catch (Exception e) {
			assertTrue(true); // we expect it to fail
		}
	}

}