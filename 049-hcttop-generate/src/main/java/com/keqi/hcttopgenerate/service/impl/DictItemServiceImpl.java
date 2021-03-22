package com.keqi.hcttopgenerate.service.impl;

import com.keqi.hcttopgenerate.entity.DictItem;
import com.keqi.hcttopgenerate.dto.DictItemDto;
import com.keqi.hcttopgenerate.dao.DictItemDao;
import com.keqi.hcttopgenerate.service.DictItemService;
import com.hcttop.ssm.dao.BaseDao;
import com.hcttop.ssm.service.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictItemServiceImpl extends AbstractService<DictItem, DictItemDto> implements DictItemService {

	@Autowired
	private DictItemDao dictItemDao;

	@Override
	protected BaseDao<DictItem, DictItemDto> getDao() {
		return this.dictItemDao;
	}
}
