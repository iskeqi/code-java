package com.keqi.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.GlobalFilter;

@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		GlobalFilter globalFilter;
		SpringApplication.run(GatewayApplication.class, args);
	}

	 /*
		 网关功能：
			身份认证和权限校验
			服务路由、负载均衡
			请求限流
	  */

	/*
		路由断言工厂 Route Predicate Factory
			配置文件中写的断言规则只是字符串，这些字符串会被 Predicate Factory 读取并处理，转变为路由判断的条件
			例如：Path=/user/** 是按照路径匹配，这个路由规则是由：
				org.springframework.cloud.gateway.handler.predicate.PathRoutePredicateFactory

			gateway 提供了11 种基本的 predicate 工厂：（最常用的其实还是 Path 这种规则）
			参考：https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/#the-after-route-predicate-factory
	 */

	/*
		路由过滤器 GatewayFilter

			GatewayFilter 是网关中提供的一种过滤器，可以对进入网关的请求和微服务返回的响应做处理（不仅是请求哦，还有响应呢）

			gateway 提供了 31 种不同的路由过滤器工厂
			参考：https://docs.spring.io/spring-cloud-gateway/docs/current/reference/html/#gatewayfilter-factories


	 */

	/*
		全局过滤器 GlobalFilter

			全局过滤器的作用也是处理一切进入网关的请求和微服务响应，和 GatewayFilter 的作用是一样的
			区别在于 GatewayFilter是通过配置文件定义的，处理逻辑是固定的，而GlobalFilter的逻辑需要自己写代码实现
			定义方式是实现 GlobalFilter 接口

			// exchange 代表请求上下文，整个流程中都共享这一个对象
			// chain 用来把请求委托给下一个过滤器
			Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain);
	 */

	/*
		过滤器执行顺序：

			请求进入网关会遇到三类过滤器：DefaultFilter、当前路由的过滤器、GlobalFilter，
			请求路由后，会将当前路由过滤器和DefaultFilter、GlobalFilter合并到一个过滤器链中，排序后依次执行

			排序的优先级就是：DefaultFilter、路由过滤器、GlobalFilter，然后再同类的内部进行排序

			每一个过滤器都必须指定一个int类型的order值，order值越小，优先级越高，执行顺序越靠前
			GlobalFilter通过实现OrderId接口，或者添加@Order注解来指定order值，由开发人员指定
			路由过滤器和defaultFilter的order会按照声明顺序从1递增

			这三者可以通过 GatewayFilter 接口进行统一使用和管理，所以他们可以放在一起

	 */

	/*
		跨域问题处理：实际生产中使用 nginx 进行请求转发，在这里进行跨域配置即可
			但是在开发中，也还是有必要进行跨域配置的
			gateway 可以进行跨域配置，而且只需要配置一次就好


	 */
}
