package com.qjzh.idomp.zjc.core.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 基础DO实体类(其他实体DO类需要继承此类)
 *
 * @author keqi
 */
@Data
@Accessors(chain = true)
public class BaseDO {

	// 设置主键策略为数据库ID自增
	@TableId(type = IdType.AUTO)
	private Long id;

	// insert时会填充此字段
	@TableField(fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	// insert和update时都会填充字段
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

	private String createBy;

	private String updateBy;

}
