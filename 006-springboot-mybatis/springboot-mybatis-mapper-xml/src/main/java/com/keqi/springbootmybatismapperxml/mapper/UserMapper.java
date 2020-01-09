package com.keqi.springbootmybatismapperxml.mapper;

import com.keqi.springbootmybatismapperxml.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Set;

public interface UserMapper {

	//=======================测试增删改方法的使用=========================================//

	/*
		其中insert/delete/update类型的接口方法可以不设置方法返回值，也可以设置
		但是方法返回值仅仅代表本次操作影响的行数
	 */
	int insertUser(User user);

	int deleteUserById(Long id);

	int updateUserById(User user);

	//=======================测试基本查询方法的使用==================================//

	// 只有select类型的方法返回值，才是真正查询出来的记录封装成的对象

	User selectUserById(Long id);

	User selectUserByUsername(String username);

	//=======================测试方法参数的映射===========================================//

	void singleMethodParam(String username);

	void singleEntityParam(User user);

	void multiMethodParam(@Param("id") Long id, @Param("username") String username);

	void multiEntityParam(@Param("user1") User user1, @Param("user2") User user2);

	void listParam(List<User> userList);

	void setParam(Set<User> userSet);

	void arrayParam(User[] users);

	//===========================================================================//


	//===========================================================================//

}
