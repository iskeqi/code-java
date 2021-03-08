package com.keqi.grid.sys.domain.db;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalDate;

/**
 * 用户表
 */
@Data
public class AccountDO {

	/**
	 * 用户id
	 */
	private Long id;

	/**
	 * 用户名
	 */
	private String account;

	/**
	 * 姓名
	 */
	private String nickName;

	/**
	 * 手机号
	 */
	private String phone;

	/**
	 * 性别[0 男，1女]
	 */
	private Integer gender;

	/**
	 * 出生日期
	 */
	private LocalDate birthday;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 用户描述
	 */
	private String note;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 盐
	 */
	private String salt;

	/**
	 * 用户头像图片名称
	 */
	private String fileName;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;

	/**
	 * 是否删除（0 未删除，1 已删除）
	 */
	private Integer deleted;

}