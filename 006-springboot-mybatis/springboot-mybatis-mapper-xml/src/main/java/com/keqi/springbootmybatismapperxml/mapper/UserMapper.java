package com.keqi.springbootmybatismapperxml.mapper;

import com.keqi.springbootmybatismapperxml.domain.User;

public interface UserMapper {

	/*
		其中insert/delete/update类型的接口方法可以不设置方法返回值，也可以设置
		但是方法返回值仅仅代表本次操作影响的行数
	 */
	int insertUser(User user);

	int deleteUserById(Long id);

	int updateUserById(User user);

	// 只有select类型的方法返回值，才是真正查询出来的记录封装成的对象

	User selectUserById(Long id);

}
