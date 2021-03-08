package com.keqi.grid.sys.domain.db;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 文件表
 */
@Data
public class UploadFileDO {

	/**
	 * 文件id
	 */
	private Long id;

	/**
	 * 文件名称
	 */
	private String name;

	/**
	 * 文件存储路径（相对路径）
	 */
	private String path;

	/**
	 * 文件类型
	 */
	private String type;

	/**
	 * 文件大小（单位：字节）
	 */
	private Long size;

	/**
	 * 是否删除（0 未删除，1 已删除）
	 */
	private Integer deleted;

	/**
	 * 创建时间
	 */
	private LocalDateTime createTime;

	/**
	 * 修改时间
	 */
	private LocalDateTime updateTime;

}