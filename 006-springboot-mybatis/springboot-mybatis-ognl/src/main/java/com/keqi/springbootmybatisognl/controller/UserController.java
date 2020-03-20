package com.keqi.springbootmybatisognl.controller;

import com.keqi.springbootmybatisognl.common.AjaxEntity;
import com.keqi.springbootmybatisognl.common.AjaxEntityBuilder;
import com.keqi.springbootmybatisognl.domain.SysUser;
import com.keqi.springbootmybatisognl.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	private SysUserMapper sysUserMapper;

	@GetMapping("/test")
	public AjaxEntity test(Integer id) {
		SysUser sysUser = new SysUser();
		sysUser.setUserName("keqi" + id);
		sysUser.setNickName("柯琦" + id);
		this.sysUserMapper.insert(sysUser);
		return AjaxEntityBuilder.success(sysUser);
	}
}
