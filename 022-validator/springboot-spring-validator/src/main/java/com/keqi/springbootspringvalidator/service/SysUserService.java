package com.keqi.springbootspringvalidator.service;

import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

/**
 * Service接口
 */
@Validated
public interface SysUserService {

	/**
	 * 测试在Service上是否可以使用这种校验（可见，这是支持的，但是它不能使用在实现类上，必须是在接口中声明）
	 * @param username username
	 */
	void sysUserCreateForm2Service(@Length(min = 3, message = "username不能少于3个字符") String username);
}
