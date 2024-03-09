package com.practice.spring.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.spring.limitsservice.config.PropertiesConfig;
import com.practice.spring.limitsservice.controller.bean.Limits;

@RestController
public class LimitsServiceController {
	@Autowired
	private PropertiesConfig config;
	
	@GetMapping("limits")
	public Limits getLimits() {
		return new Limits(config.getMinimum(), config.getMaximum());
		//return new Limits(1, 1000);
	}
}
