package com.keqi.bestpracticeone.sys.domain.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DictItemPageParam {

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
     * 当前页数（最小为1）（命名和 MyBatisPlus 保持一致）
     */
    protected int current = 1;

    /**
     * 每页大小（最大为50）（命名和 MyBatisPlus 保持一致）
     */
    protected int size = 10;
}
