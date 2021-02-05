package com.keqi.seed.sys.pojo;

import com.keqi.seed.sys.domain.vo.MenuVO;
import lombok.Data;

import java.util.List;

/**
 * 登录用户信息实体类
 *
 * @author keqi
 */
@Data
public class LoginUserBO {

	/**
	 * 用户id
	 */
	private Long id;

	/**
	 * 登录用户账号名
	 */
	private String account;

	/**
	 * token 到期时间
	 */
	private Long expirationTime;

	/**
	 * token
	 */
	private String token;

	/**
	 * 登录设备类型
	 */
	private String devType;

	/**
	 * 用户拥有的权限列表
	 */
	private List<String> permissList;

	/**
	 * 用户拥有的角色列表
	 */
	private List<String> roleList;

	/**
	 * 用户拥有的菜单列表
	 */
	private List<MenuVO> menuVOS;
}
