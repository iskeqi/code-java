package com.keqi.springbootmybatistypehandler.controller;

import com.keqi.springbootmybatistypehandler.common.AjaxEntity;
import com.keqi.springbootmybatistypehandler.common.AjaxEntityBuilder;
import com.keqi.springbootmybatistypehandler.domain.SysUser;
import com.keqi.springbootmybatistypehandler.mapper.SysUserMapper;
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
