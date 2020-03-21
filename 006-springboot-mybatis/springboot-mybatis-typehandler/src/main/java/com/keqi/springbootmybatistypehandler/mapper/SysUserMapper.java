package com.keqi.springbootmybatistypehandler.mapper;

import com.keqi.springbootmybatistypehandler.domain.SysUser;

public interface SysUserMapper {
	int deleteById(Long userId);

	int insert(SysUser record);

	int insertSelective(SysUser record);

	SysUser findOneById(Long userId);

	int updateByIdSelective(SysUser record);

	int updateById(SysUser record);
}