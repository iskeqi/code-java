package com.keqi.springbootmybatistypehandler.controller;

import com.keqi.springbootmybatistypehandler.common.AjaxEntity;
import com.keqi.springbootmybatistypehandler.common.AjaxEntityBuilder;
import com.keqi.springbootmybatistypehandler.domain.SysUser;
import com.keqi.springbootmybatistypehandler.enumeration.GenderEnum;
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
		sysUser.setSex(GenderEnum.FEMALE);

		// Java 中的 enum 对象 通过自定义的类型转换器去除枚举对象中的属性，作为值存储进 DB 中
		this.sysUserMapper.insert(sysUser);

		// 自定义的类型转换器把 DB 中的数字转换成了对应的枚举对象
		SysUser one = this.sysUserMapper.findOneById(sysUser.getUserId());

		// 这个过程实现了 DB 中存数字，程序中使用枚举、前端使用的是字符串。这是一个3方共赢的解决方案。

		return AjaxEntityBuilder.success(one);
	}
}
