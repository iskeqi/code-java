package com.keqi.seed.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.seed.sys.domain.db.DictItemDO;

import java.util.List;

public interface DictItemDOMapper extends BaseMapper<DictItemDO> {
    List<DictItemDO> listByTypeCode(String typeCode);
}