package com.keqi.bestpracticeone.core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 基础查询实体类（仅用于统一公共字段命名，不要求必须继承，可以拷贝需要的属性至自己的Param实体类中，且推荐这么做）
 */
public class QueryBaseParam {

    /**
     * 当前页数（最小为1）（命名和 MyBatisPlus 保持一致）
     */
    protected int current = 1;

    /**
     * 每页大小（最大为50）（命名和 MyBatisPlus 保持一致）
     */
    protected int size = 10;

    /**
     * 搜索字段名称
     */
    protected String searchName;

    /**
     * 搜索字段值
     */
    protected String searchValue;

    /**
     * 开始日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate beginDate;

    /**
     * 结束日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    protected LocalDate endDate;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime beginTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime endTime;

    /**
     * 排序字段
     */
    protected String orderFiled;

    /**
     * 排序类型（升序：asc，降序：desc）
     */
    protected String orderType;
}
