package com.keqi.apihu.manage.service.impl;

import com.keqi.apihu.core.common.Auth;
import com.keqi.apihu.core.common.PageVO;
import com.keqi.apihu.manage.domain.*;
import com.keqi.apihu.manage.domain.enums.DeleteFlagEnum;
import com.keqi.apihu.manage.domain.param.DesignatedPersonnelParam;
import com.keqi.apihu.manage.domain.param.ListMyProjectParam;
import com.keqi.apihu.manage.domain.param.ProjectListParam;
import com.keqi.apihu.manage.mapper.AccountProjectMapper;
import com.keqi.apihu.manage.mapper.ProjectMapper;
import com.keqi.apihu.manage.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

	private final ProjectMapper projectMapper;
	private final AccountProjectMapper accountProjectMapper;

	@Override
	@Transactional
	public void createProject(ProjectDO projectDO) {
		this.projectMapper.insert(projectDO);
	}

	@Override
	@Transactional
	public void deleteProject(Long id) {
		ProjectDO projectDO = new ProjectDO();
		projectDO.setId(id);
		projectDO.setDeleteFlag(DeleteFlagEnum.Y);
		this.projectMapper.updateByPrimaryKeySelective(projectDO);
	}

	@Override
	@Transactional
	public void updateProject(ProjectDO projectDO) {
		this.projectMapper.updateByPrimaryKeySelective(projectDO);
	}

	@Override
	public PageVO listProject(ProjectListParam projectListParam) {
		long total = this.projectMapper.count(projectListParam);
		List<ProjectDO> projectDOList = null;
		if (total > 0) {
			projectDOList = this.projectMapper.list(projectListParam);
		}
		return new PageVO(total, projectDOList);
	}

	@Override
	@Transactional
	public void designatedPersonnel(DesignatedPersonnelParam designatedPersonnelParam) {
		Long projectId = designatedPersonnelParam.getProjectId();
		List<Long> accountIdList = designatedPersonnelParam.getAccountIdList();

		this.accountProjectMapper.deleteByProjectId(projectId);

		List<AccountProjectDO> list = new ArrayList<>(accountIdList.size());
		for (Long accountId : accountIdList) {
			list.add(new AccountProjectDO(accountId, projectId));
		}

		this.accountProjectMapper.batchInsert(list);
	}

	@Override
	public List<ProjectDO> listMyProject(ListMyProjectParam listMyProjectParam) {
		listMyProjectParam.setAccountId(Auth.getLoginAccountId());

		// 如何把当前用户最近一次操作的项目排在第一位，在内存中使用一个Map进行存储吧

		return this.projectMapper.listMyProject(listMyProjectParam);
	}
}
