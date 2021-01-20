package com.keqi.knife4j.sys.domain.db;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 文件表
 */
@Data
@TableName(value = "sys_upload_file")
public class UploadFileDO {

	/**
	 * 文件id
	 */
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

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