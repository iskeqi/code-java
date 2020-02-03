package com.qjzh.idomp.zjc.sc.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 字典数据表
 * </p>
 *
 * @author keqi
 * @since 2020-02-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DictDataVO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 字典标签
     */
    private String dictLabel;

    /**
     * 字典键值
     */
    private String dictValue;

    /**
     * 备注
     */
    private String remark;

    /**
     * 样式属性（其他样式扩展）
     */
    private String cssClass;

    /**
     * 表格回显样式
     */
    private String listClass;
}
