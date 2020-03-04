package com.qjzh.idomp.zjc.sc.domain;

import com.qjzh.idomp.zjc.core.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DictData extends BaseEntity {

    private static final long serialVersionUID = 5081153680325410596L;

    @NotNull
    private String dictType;

    private String dictLabel;

    private String dictValue;

    private Integer dictSort;

    private String remark;

    private String cssClass;

    private String listClass;

}