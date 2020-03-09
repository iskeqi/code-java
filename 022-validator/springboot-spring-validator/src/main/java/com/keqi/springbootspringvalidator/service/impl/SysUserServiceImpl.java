package com.keqi.springbootspringvalidator.service.impl;

import com.keqi.springbootspringvalidator.service.SysUserService;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Override
	public void sysUserCreateForm2Service(String username) {
		System.out.println("serviceImpl ...");
	}

}
