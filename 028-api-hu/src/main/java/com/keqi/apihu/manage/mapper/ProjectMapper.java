package com.keqi.apihu.manage.mapper;

import com.keqi.apihu.manage.domain.param.ListMyProjectParam;
import com.keqi.apihu.manage.domain.ProjectDO;
import com.keqi.apihu.manage.domain.param.ProjectListParam;

import java.util.List;

public interface ProjectMapper {
	int deleteByPrimaryKey(Long id);

	int insert(ProjectDO record);

	int insertSelective(ProjectDO record);

	ProjectDO selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(ProjectDO record);

	int updateByPrimaryKey(ProjectDO record);

	long count(ProjectListParam projectListParam);

	List<ProjectDO> list(ProjectListParam projectListParam);

	List<ProjectDO> listMyProject(ListMyProjectParam listMyProjectParam);
}