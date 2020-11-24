package com.keqi.springbootmybatistypehandler.domain;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.keqi.springbootmybatistypehandler.enumeration.GenderEnum;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SysUser {
	/**
	 * 用户ID
	 */
	private Long userId;

	/**
	 * 部门ID
	 */
	private Long deptId;

	/**
	 * 用户账号
	 */
	private String userName;

	/**
	 * 用户昵称
	 */
	private String nickName;

	/**
	 * 用户类型（00系统用户）
	 */
	private String userType;

	/**
	 * 用户邮箱
	 */
	private String email;

	/**
	 * 手机号码
	 */
	private Double phonenumber;

	/**
	 * 用户性别（0男 1女 2未知）
	 */
	private GenderEnum sex;

	/**
	 * 头像地址
	 */
	private String avatar;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 帐号状态（0正常 1停用）
	 */
	private String status;

	/**
	 * 删除标志（0代表存在 2代表删除）
	 */
	private String delFlag;

	/**
	 * 最后登陆IP
	 */
	private String loginIp;

	/**
	 * 最后登陆时间
	 */
	private LocalDateTime loginDate;

	/**
	 * 创建者
	 */
	private String createBy;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 更新者
	 */
	private String updateBy;

	/**
	 * 更新时间
	 */
	private LocalDateTime updateTime;

	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 测试 JSON 字段
	 */
	private JSONObject jsonStr;

	/**
	 * 测试 JSON Array 字段
	 */
	private JSONArray jsonArrayStr;
}