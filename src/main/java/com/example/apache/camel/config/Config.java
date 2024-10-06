package com.example.apache.camel.config;

import java.util.List;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Autowired(required = false)
    List<RouteBuilder> producers;
}
