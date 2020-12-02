package com.keqi.bestpracticeone.sys.domain.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictItemParam {

    /**
     * 字典记录主键
     */
    private Long id;

    /**
     * 字典类型编码
     */
    private String typeCode;

    /**
     * 字典类型名称
     */
    private String typeName;

    /**
     * 字典项编码
     */
    private String itemCode;

    /**
     * 字典项值
     */
    private String itemName;

    /**
     * 字典项排序
     */
    private Integer itemSort;

    /**
     * 字典项备注字段
     */
    private String itemRemark;

    /**
     * 字典项样式属性(备用字段)
     */
    private String itemCss;

}
