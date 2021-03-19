package com.keqi.dataxweb.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@TableName(value = "t_task_log")
public class TaskLog {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 任务id
     */
    @TableField(value = "task_id")
    private Integer taskId;

    /**
     * 是否执行成功[ 0 成功，1 失败]
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 执行开始时间
     */
    @TableField(value = "start_date")
    private LocalDateTime startDate;

    /**
     * 执行结束时间
     */
    @TableField(value = "end_date")
    private LocalDateTime endDate;

    /**
     * 创建时间
     */
    @TableField(value = "create_date")
    private LocalDateTime createDate;

    /**
     * 创建人
     */
    @TableField(value = "create_user_id")
    private Integer createUserId;

    /**
     * 日志存放地址
     */
    @TableField(value = "file_path")
    private String filePath;

    /**
     * 数据条数
     */
    @TableField(value = "data_count")
    private Integer dataCount;
}