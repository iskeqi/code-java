package com.keqi.springbootmpdynamic.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.keqi.springbootmpdynamic.domain.UserDO;
import com.keqi.springbootmpdynamic.mapper.UserMapper;
import com.keqi.springbootmpdynamic.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

	@DS("#header.pollName")
	public void saveToSlave() {
		UserDO userDO = new UserDO();
		userDO.setAge(12);
		userDO.setName("keqi");
		this.save(userDO);
	}

}
