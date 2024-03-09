package com.practice.unittesting.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.practice.unittesting.beans.Item;
import com.practice.unittesting.constants.ControllerMappings;
import com.practice.unittesting.service.ItemService;

/**
 * This is to load only HelloWorldController as it's mentioned in @WebMvcTest
 * 
 * @author Pattabhi
 *
 */
//@ExtendWith(SpringExtension.class)
@WebMvcTest
//@SpringBootTest
public class ItemControllerTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	ItemService itmSrvc;

	@Test
	public void dummyUrl() throws Exception {
		Item itm = new Item(1, "Orange", 2, 12);
		RequestBuilder request = MockMvcRequestBuilders.get(ControllerMappings.DUMMY_ITEM_GET_URL)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult mvcResult = mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().json("{\"id\": 1,\"name\": \"Orange\",\"price\": 2}"))
				.andReturn();
		// assertEquals(itm.toString(), mvcResult.getResponse().getContentAsString());
		JSONAssert.assertEquals("{\"id\": 1,\"name\": \"Orange\",\"price\": 2}",
				mvcResult.getResponse().getContentAsString(), false);
	}

	@Test
	public void getItemfromService() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get(ControllerMappings.ITEM_BY_SERVICE_GET_URL)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(request).andReturn();
		System.out.println(result.getResponse().toString());
		assertNotNull(result.getResponse());
	}
}
