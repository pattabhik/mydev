package com.learning.rest.services.resfulwebservices.controller;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.learning.rest.services.resfulwebservices.beans.FilterBean;

/**
 *
 * @author Pattabhi
 */
@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		FilterBean filterBean = new FilterBean("value1", "value2", "value3");
		// this is dynamic filtering not to show some fields of bean in response json
		MappingJacksonValue value = new MappingJacksonValue(filterBean.getClass());
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field1");
		FilterProvider filters = new SimpleFilterProvider().addFilter("filterBean", filter);
		value.setFilters(filters);

		try {
			Class filterBean2 = Class.forName("FilterBean");
			try {
				FilterBean filterBean3 = (FilterBean) filterBean2.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return value;
	}
}
