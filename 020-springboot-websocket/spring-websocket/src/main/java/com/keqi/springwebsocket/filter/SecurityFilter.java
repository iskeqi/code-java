package com.keqi.springwebsocket.filter;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = {"/*"})
public class SecurityFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("SecurityFilter.init()");
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		log.info("SecurityFilter.doFilter()");
		// SpringMVC 的拦截器Interceptor是无法拦截 WebSocket 请求的，但是 JavaWEB 的过滤器Filter却能否非常有效的在握手阶段就拦截下来
		// 当然，发送消息阶段就无法拦截了

		// 这个现象其实很好理解，SpringMVC 是专门针对于HTTP请求进行处理的框架，它提供的拦截器也仅仅是用基于拦截经过 DispatcherServlet 代理的HTTP请求
		// JavaWEB 中抽象出来的 Filter 是针对整个 Servlet 容器实现的HTTP请求过滤器，当然能够有效拦截了，毕竟 websocket 建立连接时，
		// 就是使用的 http 协议，然后才升级成 websocket 的
		filterChain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void destroy() {
		log.info("SecurityFilter.destroy()");
	}
}
