package com.maersk.containers.resttemplate;

/**
 * Rest template client
 * 
 * @author Pattabhi
 *
 */
public interface RestTemplateClient {

	/**
	 * 
	 * @param <T>
	 * @param <R>
	 * @param request
	 * @param response
	 */
	public Object invoke(final String url, final Object payload, final Class<?> responseType);
}
