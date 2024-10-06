package com.example.apache.camel.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
	
	private final Map<String, RouteBuilder> producers;

	public ProducerService(List<RouteBuilder> producers) {
		super();
		this.producers = producers.stream()
				.collect(Collectors.toMap(producer -> producer.getClass().getSimpleName(), Function.identity()));
	}

	public void execute(String produceType) throws Exception {
		producers.get(produceType).configure();
	}

}
