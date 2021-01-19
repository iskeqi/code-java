package com.keqi.knife4j.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.knife4j.core.pojo.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 角色表
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName(value = "sys_role")
public class RoleDO extends BaseDO {


	/**
	 * 角色名称
	 */
	@TableField(value = "name")
	private String name;


}