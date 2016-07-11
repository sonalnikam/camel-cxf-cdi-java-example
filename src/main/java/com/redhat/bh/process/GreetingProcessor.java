package com.redhat.bh.process;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.cxf.message.MessageContentsList;

@Singleton
@Named("greetingProcessor")
public class GreetingProcessor {
	
	private static final String ENV_HOSTNAME = "HOSTNAME";
	private static final String MSG_GREETING = "Good day, %s! I am %s";

	public void processor(Exchange exchange) {
		String host = System.getenv(ENV_HOSTNAME);
		
		Message in = exchange.getIn();
		String name = null;
		
		MessageContentsList mcl = (MessageContentsList) in.getBody();
		if (!mcl.isEmpty())
		{
			name = (String) mcl.get(0);
		}
		
		in.setBody(String.format(MSG_GREETING, name, host));
		
		exchange.setIn(in);
	}

}
