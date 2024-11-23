package com.maersk.containers.beans.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Error bean to return as response in case of any exceptions in the application
 * 
 * @author Pattabhi
 */

public class ErrorResponseBean {
	private LocalDateTime timestamp;
	private List<String> errors = new ArrayList<>();

	public ErrorResponseBean(LocalDateTime timestamp) {
		super();
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ErrorResponseBean [timestamp=" + timestamp + ", errors=" + errors + "]";
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
