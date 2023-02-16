package com.maersk.containers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Spring boot application
 * 
 * @author Pattabhi
 *
 */
@SpringBootApplication
@EnableCaching
public class ContainersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContainersApplication.class, args);
	}

}
