package com.keqi.apihu.manage.controller;

import com.keqi.apihu.core.common.AjaxEntity;
import com.keqi.apihu.core.common.AjaxEntityBuilder;
import com.keqi.apihu.manage.domain.param.DesignatedPersonnelParam;
import com.keqi.apihu.manage.domain.ProjectDO;
import com.keqi.apihu.manage.domain.param.ProjectListParam;
import com.keqi.apihu.manage.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目管理
 */
@RestController
@AllArgsConstructor
public class ProjectController {

	private final ProjectService projectService;

	@PostMapping("/project/create")
	public AjaxEntity create(@RequestBody ProjectDO projectDO) {
		this.projectService.createProject(projectDO);
		return AjaxEntityBuilder.success();
	}

	@PostMapping("/project/delete")
	public AjaxEntity delete(Long id) {
		this.projectService.deleteProject(id);
		return AjaxEntityBuilder.success();
	}

	@PostMapping("/project/update")
	public AjaxEntity update(@RequestBody ProjectDO projectDO) {
		this.projectService.updateProject(projectDO);
		return AjaxEntityBuilder.success();
	}

	@PostMapping("/project/list")
	public AjaxEntity list(@RequestBody ProjectListParam projectListParam) {
		return AjaxEntityBuilder.successList(this.projectService.listProject(projectListParam));
	}

	@PostMapping("/project/designatedPersonnel")
	public AjaxEntity designatedPersonnel(@RequestBody DesignatedPersonnelParam designatedPersonnelParam) {
		this.projectService.designatedPersonnel(designatedPersonnelParam);
		return AjaxEntityBuilder.success();
	}
}
