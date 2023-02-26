package com.maersk.containers.resttemplate;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.maersk.containers.constants.ContainerConstants;
import com.maersk.containers.constants.ExceptionConstants;
import com.maersk.containers.log.LoggerUtil;

/**
 * Rest client implementation class
 * 
 * @author Pattabhi
 *
 */
public class RestTemplateClientImpl implements RestTemplateClient {

	private static final Logger LOG = LoggerFactory.getLogger(RestTemplateClientImpl.class);

	private RestTemplate restTemplate;

	private final String mockEnabledKey;

	public RestTemplateClientImpl(int timoutMilSecnds, String mockEnabledKey) {
		this.mockEnabledKey = mockEnabledKey;
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(timoutMilSecnds);
		factory.setReadTimeout(timoutMilSecnds);

		this.restTemplate = new RestTemplate(factory);
	}

	@Override
	public Object invoke(final String url, final Object payload, final Class<?> responseType) {
		ResponseEntity<?> resp = null;
		try {
			resp = this.restTemplate.exchange(url, HttpMethod.POST, getRequestBody(payload), responseType);
		} catch (Exception exp) {
			// mocking only based on the flag,not for every environment
			if (ContainerConstants.FLAG_Y.equalsIgnoreCase(this.mockEnabledKey)) {
				resp = new MockResponse().getResponse(url, responseType);
			}
			LoggerUtil.error(LOG, exp,
					ExceptionConstants.REST_URL_CONNECTION_EXCEPTION_ERROR_MESSAGE.concat("[" + url + "]"));
		}
		return getResponse(resp);
	}

	private HttpEntity<Object> getRequestBody(final Object payload) {
		final HttpHeaders reqHdrs = new HttpHeaders();
		reqHdrs.setContentType(MediaType.APPLICATION_JSON);
		reqHdrs.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		return new HttpEntity<Object>(payload, reqHdrs);
	}

	private Object getResponse(final ResponseEntity<?> resp) {
		Object respnsBdy = null;
		if (resp != null && resp.getStatusCode() == HttpStatus.OK) {
			respnsBdy = resp.getBody();
		}

		return respnsBdy;
	}
}
