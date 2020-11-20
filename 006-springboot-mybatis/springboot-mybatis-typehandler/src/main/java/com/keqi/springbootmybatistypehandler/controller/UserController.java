package com.keqi.springbootmybatistypehandler.controller;

import com.alibaba.fastjson.JSON;
import com.keqi.springbootmybatistypehandler.common.AjaxEntity;
import com.keqi.springbootmybatistypehandler.common.AjaxEntityBuilder;
import com.keqi.springbootmybatistypehandler.domain.SysUser;
import com.keqi.springbootmybatistypehandler.enumeration.GenderEnum;
import com.keqi.springbootmybatistypehandler.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	@Autowired
	private SysUserMapper sysUserMapper;

	@GetMapping("/testEnum")
	public AjaxEntity testEnum(Integer id) {
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

	@PostMapping("/testJSON")
	public AjaxEntity testJSON(@RequestBody SysUser sysUser) {
		// 这里的 jsonStr 属性直接使用了 JSONObject 类型来接口 JSON 对象，完全没有问题
		// JSONObject 类型的对象 通过类型转换器转成了 string ，然后存储进 DB 中的 json 类型字段 jsonStr
		// 从DB 中取出的 json 类型字段值，又通过类型转换器转成了 JSONObject 对象
		this.sysUserMapper.insert(sysUser);
		SysUser oneById = this.sysUserMapper.findOneById(sysUser.getUserId());
		return AjaxEntityBuilder.success(oneById);
	}
}
