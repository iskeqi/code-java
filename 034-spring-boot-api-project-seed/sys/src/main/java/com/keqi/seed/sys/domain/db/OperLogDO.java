package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 操作日志记录表
 */
@Data
@TableName(value = "sys_oper_log")
public class OperLogDO {

	/**
	 * 日志主键
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 操作名称
	 */
	@TableField(value = "`name`")
	private String name;

	/**
	 * 方法名称（对应 Controller 方法名称）
	 */
	@TableField(value = "`method`")
	private String method;

	/**
	 * 请求方式（GET、POST）
	 */
	@TableField(value = "`type`")
	private String type;

	/**
	 * 请求URL
	 */
	@TableField(value = "url")
	private String url;

	/**
	 * 请求IP地址
	 */
	@TableField(value = "ip")
	private String ip;

	/**
	 * 请求参数类型
	 */
	@TableField(value = "content_type")
	private String contentType;

	/**
	 * 请求参数（表单参数也转成 JSON 格式保存）
	 */
	@TableField(value = "param")
	private String param;

	/**
	 * 返回参数
	 */
	@TableField(value = "`result`")
	private String result;

	/**
	 * 是否操作成功（0 成功，1 失败）
	 */
	@TableField(value = "success")
	private Integer success;

	/**
	 * 创建人员
	 */
	@TableField(value = "create_by")
	private Long createBy;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;
}