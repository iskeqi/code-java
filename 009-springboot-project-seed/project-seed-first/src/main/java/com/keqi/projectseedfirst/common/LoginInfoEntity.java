package com.keqi.projectseedfirst.common;

/**
 * 如果需要通过AOP的方式获取当前登录用户信息，就需要在实体类中实现该接口，并且必须要添加一个属性为 loginUser
 *
 * 这样做是为了减少对于实体类的侵入性
 */
public interface LoginInfoEntity {

	/** 登录用户对象 */
	// protected LoginUserBO loginUser;
}
