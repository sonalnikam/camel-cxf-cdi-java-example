package com.redhat.bh.process;

import java.util.Map;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

@Singleton
@Named("greetingProcessor")
public class GreetingProcessor {
	
	private static final String ENV_HOSTNAME = "HOSTNAME";
	private static final String MSG_GREETING = "Hi, %s! I am %s";

	public void processor(Exchange exchange) {
		String host = System.getenv(ENV_HOSTNAME);
		Message in = exchange.getIn();
		
		String name = (String) in.getBody();
		
		in.setBody(String.format(MSG_GREETING, name, host));
		
		exchange.setIn(in);
	}

}
