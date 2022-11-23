package com.maersk.containers.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.maersk.containers.log.LoggerUtil;

/**
 * @author Pattabhi
 *
 */
@ControllerAdvice
public class CustomRestExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomRestExceptionHandler.class);

	@ExceptionHandler(value = RuntimeException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public String handleDefaultError(RuntimeException ex) {
		LoggerUtil.error(LOG, "Default Error : {}", ex.getMessage());
		return ex.getMessage();
	}

}
