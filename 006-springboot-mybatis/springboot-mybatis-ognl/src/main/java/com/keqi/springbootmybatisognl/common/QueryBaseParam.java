package com.keqi.springbootmybatisognl.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 基础查询实体类（仅用于规范命名，不要求必须继承，可以拷贝需要的属性至自己的Param实体类中）
 */
@Getter
@Setter
public class QueryBaseParam {

	/** 搜索字段名称 */
	protected String searchName;

	/** 搜索字段值 */
	protected String searchValue;

	/** 开始日期 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	protected LocalDate beginDate;

	/** 结束日期 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	protected LocalDate endDate;

	/** 开始时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime beginTime;

	/** 结束时间 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime endTime;

}
