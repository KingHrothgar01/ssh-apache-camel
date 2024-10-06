package com.example.apache.camel.controller;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class ProducerController {
	
	@Autowired
	private ProducerTemplate template;

	@GetMapping(value = "/camel/{ConnectType}/produce", produces = { "text/plain" })
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody String produceOrder(@PathVariable("ConnectType") String connectionType,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		template.requestBody("direct:execute_command", "");
		return "Command Executed Successfully!";
	}

}
