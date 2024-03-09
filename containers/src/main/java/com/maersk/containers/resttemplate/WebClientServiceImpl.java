package com.maersk.containers.resttemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.maersk.containers.constants.ContainerConstants;
import com.maersk.containers.constants.ExceptionConstants;
import com.maersk.containers.log.LoggerUtil;

import reactor.core.publisher.Mono;

/**
 * Rest client implementation class
 * 
 * @author Pattabhi
 *
 */
@Component
public class WebClientServiceImpl implements RestService {

	private static final Logger LOG = LoggerFactory.getLogger(WebClientServiceImpl.class);

	@Autowired
	private WebClient webClient;

	@Value("${rest.service.mock.enabled}")
	private String mockEnabled;

	@Override
	public Object invoke(final String url, final Object payload, final Class<?> responseType) {
		Object resp = null;
		try {
			resp = webClient.post().uri(url).body(Mono.just(payload), payload.getClass())
					.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
					.accept(MediaType.APPLICATION_JSON).retrieve().onStatus(HttpStatus.INTERNAL_SERVER_ERROR::equals,
							response -> response.bodyToMono(String.class).map(Exception::new))
					.bodyToMono(responseType);
		} catch (Exception exp) {
			// mocking only based on the flag,not for every environment
			if (ContainerConstants.FLAG_Y.equalsIgnoreCase(mockEnabled)) {
				resp = Mono.just(new MockResponse().getMockResponse(url, responseType));
			}
			LoggerUtil.error(LOG, exp,
					ExceptionConstants.REST_URL_CONNECTION_EXCEPTION_ERROR_MESSAGE.concat("[" + url + "]"));
		}
		return resp;
	}
}
