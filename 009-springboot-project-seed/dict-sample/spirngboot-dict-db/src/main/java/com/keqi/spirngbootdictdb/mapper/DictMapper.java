package com.keqi.spirngbootdictdb.mapper;

import com.keqi.spirngbootdictdb.domain.Dict;
import com.keqi.spirngbootdictdb.domain.DictKey;

import java.util.List;

public interface DictMapper {
    int deleteByPrimaryKey(DictKey key);

    int insert(Dict record);

    int insertSelective(Dict record);

    Dict selectByPrimaryKey(DictKey key);

    int updateByPrimaryKeySelective(Dict record);

    int updateByPrimaryKey(Dict record);

    /**
     * 查询dictType对应的字典数据
     * @param dictType dictType
     * @return r
     */
    List<Dict> listDictByDictType(String dictType);

    /**
     * 查询字典表中所有数据
     * @return r
     */
    List<Dict> listAll();
}