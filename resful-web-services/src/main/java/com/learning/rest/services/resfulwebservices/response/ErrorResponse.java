package com.learning.rest.services.resfulwebservices.response;

import java.time.LocalDateTime;

/**
 *
 * @author Pattabhi
 */

public class ErrorResponse {
	public ErrorResponse(LocalDateTime erroredTS, String message, String details) {
		super();
		this.erroredTS = erroredTS;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getErroredTS() {
		return erroredTS;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	private LocalDateTime erroredTS;
	private String message;
	private String details;
}
