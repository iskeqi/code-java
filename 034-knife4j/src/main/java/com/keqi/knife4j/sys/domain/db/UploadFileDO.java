package com.keqi.knife4j.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.knife4j.core.pojo.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 文件表
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_upload_file")
public class UploadFileDO extends BaseDO {

	/**
	 * 文件名称
	 */
	@TableField(value = "`name`")
	private String name;

	/**
	 * 文件存储路径（相对路径）
	 */
	@TableField(value = "`path`")
	private String path;

	/**
	 * 文件类型
	 */
	@TableField(value = "`type`")
	private String type;

	/**
	 * 文件大小（单位：字节）
	 */
	@TableField(value = "`size`")
	private Long size;

	/**
	 * 逻辑删除字段（0 未删除，1 已删除）
	 */
	@TableField(value = "deleted")
	private Integer deleted;
}