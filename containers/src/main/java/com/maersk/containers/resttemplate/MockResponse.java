package com.maersk.containers.resttemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.maersk.containers.log.LoggerUtil;

/**
 * Mocking the response for dev environment as the external url(s) may not be
 * connectable
 * 
 * @author Pattabhi
 *
 */
public class MockResponse {

	private static final Logger LOG = LoggerFactory.getLogger(MockResponse.class);
	
	public ResponseEntity<?> getResponse(final String url, final Class<?> responseType) {
		String strResp = null;
		switch (url) {
		case RestClientConstant.CHECK_AVAILABLE_URL:

			strResp = getCheckAvailabilityResponseJson();
		}

		return convertToResponseEntity(strResp, responseType);
	}

	public Object getMockResponse(final String url, final Class<?> responseType) {
		String strResp = null;
		switch (url) {
		case RestClientConstant.CHECK_AVAILABLE_URL:
			strResp = getCheckAvailabilityResponseJson();
		}

		return convertJsonToObject(strResp, responseType);
	}

	private String getCheckAvailabilityResponseJson() {
		return "{\"availableSpace\" : 6}";
	}

	private ResponseEntity<?> convertToResponseEntity(final String respJson, final Class<?> responseType) {
		return new ResponseEntity<>(convertJsonToObject(respJson, responseType), HttpStatus.OK);
	}

	private Object convertJsonToObject(final String respJson, final Class<?> responseType) {
		Object rtrnObjct = null;
		try {

			ObjectMapper mapper = new ObjectMapper();
			rtrnObjct = mapper.readValue(respJson, responseType);
		} catch (JsonProcessingException exp) {
			LoggerUtil.error(LOG, exp, "Exception in converting mock json string to object");
		}
		return rtrnObjct;
	}

}
