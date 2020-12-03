package com.keqi.bestpracticeone.sys.domain.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
    * 文件表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_upload_file")
public class UploadFileDO {
    /**
     * 文件ID
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
     * 创建时间
     */
    @TableField(value = "create_time")
    private LocalDateTime createTime;

    /**
     * 逻辑删除字段（0 未删除，1 已删除）
     */
    @TableField(value = "is_deleted")
    private Integer deleted;
}