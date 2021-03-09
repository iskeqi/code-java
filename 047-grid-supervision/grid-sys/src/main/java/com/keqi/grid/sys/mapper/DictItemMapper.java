package com.keqi.grid.sys.mapper;

import com.keqi.grid.core.pojo.BaseMapper;
import com.keqi.grid.sys.domain.db.DictItemDO;

import java.util.List;

public interface DictItemMapper extends BaseMapper<DictItemDO> {

    List<DictItemDO> findAll();

}