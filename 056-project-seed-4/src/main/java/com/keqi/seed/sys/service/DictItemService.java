package com.keqi.seed.sys.service;

import com.keqi.seed.sys.domain.db.DictItemDO;
import com.keqi.seed.sys.mapper.DictItemDOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictItemService {

    @Autowired
    private DictItemDOMapper dictItemDOMapper;

    public DictItemDO insert(DictItemDO dictItemDO) {
        dictItemDOMapper.insert(dictItemDO);
        return dictItemDO;
    }

    public List<DictItemDO> listByTypeCode(String typeCode) {
        return dictItemDOMapper.listByTypeCode(typeCode);
    }
}
