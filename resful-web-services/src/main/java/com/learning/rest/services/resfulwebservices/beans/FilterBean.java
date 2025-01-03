package com.learning.rest.services.resfulwebservices.beans;

import com.fasterxml.jackson.annotation.JsonFilter;

/**
 *
 * @author Pattabhi
 */
@JsonFilter("filterBean")
public class FilterBean {
	private String field1;
	private String field2;
	// this is static filtering
	// @JsonIgnore
	private String field3;

	public FilterBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public String getField3() {
		return field3;
	}

}
