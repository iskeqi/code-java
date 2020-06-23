package com.keqi.springbootmvcparam.lifestyle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class BeanLifeStyle implements DisposableBean {

	@Override
	public void destroy() throws Exception {
		System.out.println("BeanLifeStyle -> destroy()");
	}

	@PreDestroy
	public void destroy2Annotation() {
		System.out.println("BeanLifeStyle -> destroy2Annotation()");
	}
}
