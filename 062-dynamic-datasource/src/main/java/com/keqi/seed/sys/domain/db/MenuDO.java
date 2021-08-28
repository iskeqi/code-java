package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.keqi.seed.core.pojo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单权限表
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName(value = "sys_menu")
public class MenuDO extends BaseDO {
    /**
     * 名称
     */
    @TableField(value = "`name`")
    private String name;

    /**
     * 请求URL地址
     */
    @TableField(value = "url")
    private String url;

    /**
     * ICON图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 菜单类型 [C 目录，M 菜单，B 按钮]
     */
    @TableField(value = "`type`")
    private String type;

    /**
     * 权限标识
     */
    @TableField(value = "permiss")
    private String permiss;

    /**
     * 父级ID
     */
    @TableField(value = "parent_id")
    private Long parentId;

    /**
     * 排序字段
     */
    @TableField(value = "order_num")
    private Integer orderNum;
}