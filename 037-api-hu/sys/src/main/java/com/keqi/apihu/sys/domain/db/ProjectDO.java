package com.keqi.apihu.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.apihu.core.pojo.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 项目表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_project")
public class ProjectDO extends BaseDO {
    /**
     * 项目名称
     */
    @TableField(value = "project_name")
    private String projectName;

    /**
     * 项目描述信息
     */
    @TableField(value = "project_note")
    private String projectNote;

    /**
     * 逻辑删除字段（0 未删除，1 已删除）
     */
    @TableField(value = "is_deleted")
    private Integer deleted;
}