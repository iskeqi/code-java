package com.keqi.springbootmpdynamic.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.keqi.springbootmpdynamic.domain.UserDO;

public interface UserService extends IService<UserDO> {

	void saveToSlave();
}
