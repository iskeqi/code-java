package com.keqi.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
public class ProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}

	@GetMapping("/hello")
	public Map<String, Object> getHello() {
		Map<String, Object> r = new HashMap<>();
		r.put("key", "get hello");
		System.out.println(r);
		return r;
	}

	@PostMapping("/hello")
	public Map<String, Object> postHello() {
		Map<String, Object> r = new HashMap<>();
		r.put("key", "post hello");
		return r;
	}
}
