package com.keqi.seed.sys.domain.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 字典表
 */
@Data
@TableName(value = "sys_dict_item")
public class DictItemDO {
    /**
     * 字典类型编码
     */
    @TableId(value = "type_code", type = IdType.ASSIGN_ID)
    private String typeCode;

    /**
     * 字典项编码
     */
    @TableId(value = "item_code", type = IdType.ASSIGN_ID)
    private String itemCode;

    /**
     * 字典类型名称
     */
    @TableField(value = "type_name")
    private String typeName;

    /**
     * 字典项值
     */
    @TableField(value = "item_name")
    private String itemName;

    /**
     * 排序字段
     */
    @TableField(value = "order_num")
    private Integer orderNum;
}