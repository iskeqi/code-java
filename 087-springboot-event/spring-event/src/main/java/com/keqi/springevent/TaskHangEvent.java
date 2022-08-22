package com.keqi.springevent;

import org.springframework.context.ApplicationEvent;

/**
 * 任务挂起事件
 */
public class TaskHangEvent extends ApplicationEvent {

	private String message;

	public TaskHangEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	@Override
	public String toString() {
		return "TaskHangEvent{" +
				"message='" + message + '\'' +
				'}';
	}
}
