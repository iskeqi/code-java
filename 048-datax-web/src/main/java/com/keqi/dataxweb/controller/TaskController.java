package com.keqi.dataxweb.controller;

import com.keqi.dataxweb.service.TaskExcuteService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class TaskController {

	@Resource
	private TaskExcuteService taskExcuteService;

	@PostMapping("/task/execute/{taskId}")
	public Map<String, Object> executeTask(@PathVariable Integer taskId) {
		return this.taskExcuteService.executeTask(taskId);
	}
}
