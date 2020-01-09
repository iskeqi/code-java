package com.keqi.springbootmybatis.mapper;

import com.keqi.springbootmybatis.domain.User;

/**
 * 用户Mapper
 *
 * @author keqi
 */
public interface UserMapper {

	/**
	 * 新增用户
	 *
	 * @param user 用户信息
	 * @return 结果
	 */
	void insertUser(User user);


}
