package com.maersk.containers.resttemplate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.maersk.containers.constants.ControllerMappings;

/**
 * Rest client proxy implementation
 * 
 * @author Pattabhi
 *
 */
@Component(ControllerMappings.REST_TEMPLATE_CLIENT_PROXY_QUALIFIER)
public class RestTemplateClientProxy implements RestTemplateClient {

	private RestTemplateClient restTmpltClient;

	@Value("${rest.service.mock.enabled}")
	private String mockEnabled;

	@Value("${rest.service.connection.timeout.millisenconds}")
	private int timoutMilSecnds;

	@Override
	public Object invoke(String url, Object payload, Class<?> responseType) {
		if (restTmpltClient == null) {
			restTmpltClient = new RestTemplateClientImpl(timoutMilSecnds, mockEnabled);
		}

		return restTmpltClient.invoke(url, payload, responseType);
	}

}
