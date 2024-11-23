package com.practice.spring.limitsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LimitsServiceConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsServiceConfigServerApplication.class, args);
	}

}
