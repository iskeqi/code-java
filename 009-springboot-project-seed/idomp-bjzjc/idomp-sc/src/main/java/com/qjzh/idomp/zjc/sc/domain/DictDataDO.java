package com.qjzh.idomp.zjc.sc.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.qjzh.idomp.zjc.core.common.BaseDO;
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
@TableName("t_sys_dict_data")
public class DictDataDO extends BaseDO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 字典类型
     */
    private String dictType;

    /**
     * 字典标签
     */
    private String dictLabel;

    /**
     * 字典键值
     */
    private String dictValue;

    /**
     * 字典排序
     */
    private Integer dictSort;

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

    /**
     * 状态（0正常 1停用）
     */
    private Integer status;

}
