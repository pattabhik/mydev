package com.maersk.containers.config;

import java.lang.reflect.Method;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.maersk.containers.constants.ContainerConstants;

/**
 * This is the configuration class for doing all the cache configuration
 *
 * @author Pattabhi
 */
@Configuration
@EnableCaching
public class CachingConfig extends CachingConfigurerSupport {
	private static String UNDERSCORE = ContainerConstants.UNDERSCORE;

	@Bean("searchKeyGenerator")
	public KeyGenerator keyGenerator() {
		return new CustomKeyGenerator();
	}

	/**
	 * This is the custom key generator for container search as it's an object
	 *
	 */
	class CustomKeyGenerator implements KeyGenerator {
		public Object generate(Object target, Method method, Object... params) {
			return target.getClass().getSimpleName() + UNDERSCORE + method.getName() + UNDERSCORE
					+ StringUtils.arrayToDelimitedString(params, UNDERSCORE);
		}
	}

	@Bean
	public CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("containersSearch");
	}

}
