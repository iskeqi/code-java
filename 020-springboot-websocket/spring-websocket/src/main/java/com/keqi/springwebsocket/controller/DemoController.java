package com.keqi.springwebsocket.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class DemoController {

	@GetMapping("/test/{msg}")
	public Map<String,Object> test(@PathVariable String msg) {
		Map<String,Object> r = new HashMap<>();
		r.put("msg", msg);
		log.info("DemoController.test()");
		return r;
	}
}
