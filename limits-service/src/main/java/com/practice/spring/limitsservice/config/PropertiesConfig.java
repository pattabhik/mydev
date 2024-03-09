package com.practice.spring.limitsservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("limits-service")
public class PropertiesConfig {
	private int minimum;
	private int maximum;
	
	public int getMinimum() {
		return minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public PropertiesConfig() {
		// TODO Auto-generated constructor stub
	}

}
