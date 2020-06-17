package com.keqi.springbootmvcparam.controller.three;

import org.springframework.web.HttpRequestHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 实现 HttpRequestHandler 的方式
 */
public class Demo2Controller implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

	}
}
