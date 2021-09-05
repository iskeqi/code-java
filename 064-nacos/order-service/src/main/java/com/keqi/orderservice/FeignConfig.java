package com.keqi.orderservice;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class FeignConfig {

	@Bean
	public Logger.Level logLevel() {
		return Logger.Level.BASIC;
	}
}
