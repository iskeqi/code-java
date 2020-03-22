package com.keqi.springbootmybatistypehandler.mapper;

import com.keqi.springbootmybatistypehandler.domain.SysUser;

public interface SysUserMapper {

	int insert(SysUser record);

	SysUser findOneById(Long userId);

}