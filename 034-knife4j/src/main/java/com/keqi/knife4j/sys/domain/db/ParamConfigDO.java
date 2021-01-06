package com.keqi.knife4j.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.knife4j.core.pojo.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 参数配置表
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_param_config")
public class ParamConfigDO  extends BaseDO {

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
	 * 类型（dictType：configType）
	 */
	@TableField(value = "param_type")
	private String paramType;

}