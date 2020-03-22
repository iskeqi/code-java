package com.keqi.projectseedsecond.module.uc.service.impl;

import com.keqi.projectseedsecond.module.uc.domain.SysUser;
import com.keqi.projectseedsecond.module.uc.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl {

	@Resource
	private SysUserMapper sysUserMapper;


	public int deleteByPrimaryKey(Long userId) {
		return sysUserMapper.deleteByPrimaryKey(userId);
	}


	public int insert(SysUser record) {
		return sysUserMapper.insert(record);
	}


	public int insertSelective(SysUser record) {
		return sysUserMapper.insertSelective(record);
	}


	public SysUser selectByPrimaryKey(Long userId) {
		return sysUserMapper.selectByPrimaryKey(userId);
	}


	public int updateByPrimaryKeySelective(SysUser record) {
		return sysUserMapper.updateByPrimaryKeySelective(record);
	}


	public int updateByPrimaryKey(SysUser record) {
		return sysUserMapper.updateByPrimaryKey(record);
	}

}
