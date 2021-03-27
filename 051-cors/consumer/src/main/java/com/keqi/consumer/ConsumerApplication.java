package com.keqi.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/send")
	public Map send(String message) {
		// 可见，其实不处于浏览器中发送网络请求时，是不存在跨域问题的，后台服务器并不会去限制是哪里发送过来的网络请求
		// 改返回的数据也都会返回！！！

		// 只是浏览器会去检查 js 脚本所属的服务器和目标服务器是否一致，如果不一致，再检查目标服务器响应过来的数据中，请求头中是否包含
		// Access-Control-Allow-Origin: http://localhost:8081  这个请求头，如果不包含，则直接在浏览器报错，包含则啥也不会干！

		// 有没有发现上面的安全策略其实有 bug？ 因为服务器该做的操作都已经做完了，攻击都已经实现了！其实浏览器并不是先发送请求，而是会发送一个
		// options探测请求 ，检测后台服务器是否支持（有没有在响应头中加 Access-Control-Allow-Origin），如果不支持，就直接报错！！！


		String uri = "http://localhost:8080/hello";
		ResponseEntity<Map> exchange = restTemplate.exchange(uri, HttpMethod.GET, null, Map.class);
		return exchange.getBody();
	}
}
