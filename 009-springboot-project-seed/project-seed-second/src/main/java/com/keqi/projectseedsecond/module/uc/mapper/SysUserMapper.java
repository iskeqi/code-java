package com.keqi.projectseedsecond.module.uc.mapper;

import com.keqi.projectseedsecond.module.uc.domain.SysUser;

public interface SysUserMapper {
	int deleteByPrimaryKey(Long userId);

	int insert(SysUser record);

	int insertSelective(SysUser record);

	SysUser selectByPrimaryKey(Long userId);

	int updateByPrimaryKeySelective(SysUser record);

	int updateByPrimaryKey(SysUser record);
}