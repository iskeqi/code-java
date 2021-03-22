package com.keqi.hcttopgenerate.dao;

import com.keqi.hcttopgenerate.dto.DictItemDto;
import com.keqi.hcttopgenerate.entity.DictItem;
import com.keqi.hcttopgenerate.mapper.DictItemMapper;
import com.hcttop.ssm.dao.AbstractDao;
import com.hcttop.ssm.mapper.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DictItemDaoImpl extends AbstractDao<DictItem, DictItemDto> implements DictItemDao {

    @Autowired
    private DictItemMapper dictItemMapper;

    @Override
    protected BaseMapper<DictItem, DictItemDto> getMapper() {
        return this.dictItemMapper;
    }
}