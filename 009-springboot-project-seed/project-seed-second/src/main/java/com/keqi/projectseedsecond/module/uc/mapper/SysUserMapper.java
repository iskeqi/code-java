package com.keqi.projectseedsecond.module.uc.mapper;

import com.keqi.projectseedsecond.module.uc.domain.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserMapper {
	int deleteByPrimaryKey(Long userId);

	int insert(SysUser record);

	int insertSelective(SysUser record);

	SysUser selectByPrimaryKey(Long userId);

	int updateByPrimaryKeySelective(SysUser record);

	int updateByPrimaryKey(SysUser record);

	int insertList(@Param("list") List<SysUser> list);


}