package com.practice.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.unittesting.constants.ControllerMappings;

/**
 * @author Pattabhi
 *
 */
@RestController
public class HelloWorldController2 {
	@GetMapping(ControllerMappings.HELLO_WORLD_GET_URL2)
	public String helloWorld() {
		return "Hello World2";
	}
}
