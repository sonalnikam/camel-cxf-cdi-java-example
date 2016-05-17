package com.redhat.bh.process;

import java.util.Map;

import javax.inject.Named;
import javax.inject.Singleton;

import org.apache.camel.Exchange;
import org.apache.camel.Message;

@Singleton
@Named("greetingProcessor")
public class GreetingProcessor {

	public void processor(Exchange exchange) {
		Message in = exchange.getIn();
		Message out = exchange.getOut();
		out.setBody(in.getBody());
		
		exchange.setOut(out);
	}

}
