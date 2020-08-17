package com.iqb.demo.consumer;

import org.springframework.stereotype.Component;

/**
 * Handles the formatting of the response
 * @author m
 *
 */
@Component
public class MessageFormatter {
	
	public static String responseMessage = "Hello %s, I am your father!"; // TODO add into a config
	public static final char DELIM = ',';
	
	public String format(String in) {
		return String.format(responseMessage, in.substring(in.lastIndexOf(DELIM)+1, in.length() - 0).trim());
	}

}
