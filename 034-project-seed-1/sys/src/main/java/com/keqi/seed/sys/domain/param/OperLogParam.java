package com.keqi.seed.sys.domain.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 操作日志记录
 */
@Data
public class OperLogParam {

	/**
	 * 操作名称
	 */
	private String name;

	/**
	 * 方法名称（对应 Controller 方法名称）
	 */
	private String method;

	/**
	 * 请求方式（GET、POST）
	 */
	private String type;

	/**
	 * 请求URL
	 */
	private String url;

	/**
	 * 请求IP地址
	 */
	private String ip;

	/**
	 * 请求参数类型
	 */
	private String contentType;

	/**
	 * 请求参数（表单参数也转成 JSON 格式保存）
	 */
	private String param;

	/**
	 * 返回参数
	 */
	private String result;

	/**
	 * 是否操作成功（0 成功，1 失败）
	 */
	private Integer success;

	/**
	 * 创建人员
	 */
	private Long createBy;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;
}