package com.questionbank.config;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages="com.questionbank.serviceimpl")
@ImportResource("classpath:spring-service.xml")
public class ServiceConfig {

}