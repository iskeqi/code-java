package com.keqi.apihu.manage.service;

import com.keqi.apihu.core.common.PageVO;
import com.keqi.apihu.manage.domain.param.DesignatedPersonnelParam;
import com.keqi.apihu.manage.domain.param.ListMyProjectParam;
import com.keqi.apihu.manage.domain.ProjectDO;
import com.keqi.apihu.manage.domain.param.ProjectListParam;

import java.util.List;

public interface ProjectService {

	void createProject(ProjectDO projectDO);

	void deleteProject(Long id);

	void updateProject(ProjectDO projectDO);

	PageVO listProject(ProjectListParam projectListParam);

	void designatedPersonnel(DesignatedPersonnelParam designatedPersonnelParam);

	List<ProjectDO> listMyProject(ListMyProjectParam listMyProjectParam);
}
