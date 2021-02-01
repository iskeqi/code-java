package com.keqi.knife4j.sys.domain.db;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 参数配置表
 */
@Data
@TableName(value = "sys_param_config")
public class ParamConfigDO {

	/**
	 * 参数配置id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	/**
	 * 名称
	 */
	@TableField(value = "param_name")
	private String paramName;

	/**
	 * 键名
	 */
	@TableField(value = "param_key")
	private String paramKey;

	/**
	 * 键值
	 */
	@TableField(value = "param_value")
	private String paramValue;

	/**
	 * 类型（typeCode：configType）
	 */
	@TableField(value = "param_type")
	private String paramType;

	/**
	 * 创建时间
	 */
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;
}