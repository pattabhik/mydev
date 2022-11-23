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
	
	/**
	 * 
	 * @param url
	 * @param responseType
	 * @return
	 */
	public ResponseEntity<?> getResponse(final String url, final Class<?> responseType) {
		String strResp = null;
		switch (url) {
		case RestClientConstant.CHECK_AVAILABLE_URL:
			strResp = getCheckAvailabilityResponseJson();
		}

		return getCheckAvailabilityResponse(strResp, responseType);
	}

	/**
	 * 
	 * @return
	 */
	private String getCheckAvailabilityResponseJson() {
		return "{\"availableSpace\" : 6}";
	}

	/**
	 * 
	 * @param respJson
	 * @param responseType
	 * @return
	 */
	private ResponseEntity<?> getCheckAvailabilityResponse(final String respJson, final Class<?> responseType) {
		ResponseEntity<?> respEntity = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			respEntity = new ResponseEntity<>(mapper.readValue(respJson, responseType), HttpStatus.OK);
		} catch (JsonProcessingException exp) {
			LoggerUtil.error(LOG, exp, "Exception in converting mock json string to object");
		}
		return respEntity;
	}

}
