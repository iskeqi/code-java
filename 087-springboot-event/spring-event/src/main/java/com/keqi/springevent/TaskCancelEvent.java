package com.keqi.springevent;

import org.springframework.context.ApplicationEvent;

/**
 * 任务取消事件
 */
public class TaskCancelEvent extends ApplicationEvent {

	private String message;

	public TaskCancelEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	@Override
	public String toString() {
		return "TaskCancelEvent{" +
				"message='" + message + '\'' +
				'}';
	}
}
