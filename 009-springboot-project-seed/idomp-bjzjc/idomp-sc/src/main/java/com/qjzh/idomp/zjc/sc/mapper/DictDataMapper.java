package com.qjzh.idomp.zjc.sc.mapper;

import com.qjzh.idomp.zjc.sc.domain.DictData;

import java.util.List;

public interface DictDataMapper {

    /**
     * 查询指定dictType对应的字典数据列表
     * @param dictType dictType
     * @return r
     */
    List<DictData> listByDictType(String dictType);
}