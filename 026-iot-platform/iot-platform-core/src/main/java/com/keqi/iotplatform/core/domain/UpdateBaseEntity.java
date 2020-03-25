package com.keqi.iotplatform.core.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * 修改基础实体类（仅用于规范命名，不要求必须继承，可以拷贝需要的属性至自己的Param实体类中）
 */
@Getter
@Setter
public class UpdateBaseEntity {

	protected Long id;

	/**创建时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime createTime;

	/** 修改时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime updateTime;

}
