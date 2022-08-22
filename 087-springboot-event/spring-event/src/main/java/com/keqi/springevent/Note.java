package com.keqi.springevent;

import org.springframework.aop.interceptor.AsyncExecutionAspectSupport;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.AsyncConfigurerSupport;

import java.util.EventListener;
import java.util.EventObject;

public class Note {

	public void test1() {
		/*
			事件
			事件监听器
			事件发布


		 */
		//
		EventObject eventObject;
		ApplicationEvent applicationEvent;

		EventListener eventListener;
		ApplicationListener<?> applicationListener;
		org.springframework.context.event.EventListener eventListener1;

		ApplicationEventPublisher applicationEventPublisher;
		// applicationEventPublisher.publishEvent();

		AbstractApplicationContext abstractApplicationContext;

		AsyncConfigurer asyncConfigurer;
		AsyncConfigurerSupport asyncConfigurerSupport;

		// 真正的核心源码
		AsyncExecutionAspectSupport asyncExecutionAspectSupport;
	}
}
