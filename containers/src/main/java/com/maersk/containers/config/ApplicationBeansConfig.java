package com.maersk.containers.config;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import reactor.netty.http.client.HttpClient;

/**
 * 
 * @author Pattabhi
 *
 */
@Configuration
public class ApplicationBeansConfig {

	@Value("${rest.service.connection.timeout.millisenconds}")
	private int timoutMilSecnds;

	@Bean
	public RestTemplate getRestTemplate() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(timoutMilSecnds);
		factory.setReadTimeout(timoutMilSecnds);

		return new RestTemplate(factory);
	}

	@Bean
	public WebClient getWebClient() {

		HttpClient httpClient = HttpClient.create().option(ChannelOption.CONNECT_TIMEOUT_MILLIS, timoutMilSecnds)
				.responseTimeout(Duration.ofMillis(timoutMilSecnds)).doOnConnected(
						conn -> conn.addHandlerLast(new ReadTimeoutHandler(timoutMilSecnds, TimeUnit.MILLISECONDS))
								.addHandlerLast(new WriteTimeoutHandler(timoutMilSecnds, TimeUnit.MILLISECONDS)));

		return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).build();
	}
}
