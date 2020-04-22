package com.keqi.apihu.manage.domain;

import com.keqi.apihu.manage.domain.enums.DeleteFlagEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDO implements Serializable {
    /**
    * 主键
    */
    private Long id;

    /**
    * 项目名称
    */
    private String projectName;

    /**
    * 项目描述
    */
    private String projectNote;

    /**
    * 逻辑删除字段（N 未删除，Y 已删除）
    */
    private DeleteFlagEnum deleteFlag;

    /**
    * 创建时间
    */
    private LocalDateTime createTime;

    /**
    * 修改时间
    */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}