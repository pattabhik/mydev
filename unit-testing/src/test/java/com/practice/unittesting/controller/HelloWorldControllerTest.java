package com.practice.unittesting.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.practice.unittesting.constants.ControllerMappings;

/**
 * This is to load only HelloWorldController as it's mentioned in @WebMvcTest
 * 
 * @author Pattabhi
 *
 */
@WebMvcTest // (HelloWorldController.class)
public class HelloWorldControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloWorld_basic() throws Exception {
		// call GET 'url' application/json
		RequestBuilder request = MockMvcRequestBuilders.get(ControllerMappings.HELLO_WORLD_GET_URL)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(request).andReturn();

		assertEquals("Hello World", mvcResult.getResponse().getContentAsString());
	}

	@Test
	public void helloworld2() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get(ControllerMappings.HELLO_WORLD_GET_URL2)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult mvcResult = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Hello World2")).andReturn();

		assertEquals("Hello World2", mvcResult.getResponse().getContentAsString());
	}
}
