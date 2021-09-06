package com.keqi.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

// @Order(1) // 越小，优先级越高
@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {

	// 这就相当于 单体应用时，Spring MVC 的拦截器的功能

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// 获取请求参数
		ServerHttpRequest request = exchange.getRequest();
		MultiValueMap<String, String> params = request.getQueryParams();

		// 获取参数中的 authorization
		String auth = params.getFirst("authorization");

		// 判断是否等于 admin
		if ("admin".equals(auth)) {
			// 是，放行
			return chain.filter(exchange);
		}

		// 否，拦截
		// 设置状态码为 401
		exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);

		return exchange.getResponse().setComplete();
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
