package com.example.apache.camel.connector.impl;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SshProducer extends RouteBuilder {

	private static final Logger LOGGER = LoggerFactory.getLogger(SshProducer.class);

	@Override
	public void configure() throws Exception {

		LOGGER.info("+----- Executing Command Through SSH -----+");

		// Sending commands at application startup
		from("timer:timer?period=10000")
		.setBody(constant("date >> ssh/journal-startup.dat && cat ssh/journal-startup.dat%0A"))
        .to("ssh://user:password@192.168.100.68:22")
        .log(LoggingLevel.INFO, "${body}");

		// Sending commands on demand
        from("direct:execute_command")
        .setBody(constant("date >> ssh/journal-ondemand.dat && cat ssh/journal-ondemand.dat%0A"))
        .to("ssh://user:password@192.168.100.68:22")
        .log(LoggingLevel.INFO, "${body}");

		// Sending commands at application startup
		//from("timer:timer?period=100000")
		//		.setBody(constant("date >> ssh/journal-startup.dat && cat ssh/journal-startup.dat%0A"))
		//		.to("ssh://juan@hunahpu.sosa.com:22").log(LoggingLevel.INFO, "${body}");
	}
}
