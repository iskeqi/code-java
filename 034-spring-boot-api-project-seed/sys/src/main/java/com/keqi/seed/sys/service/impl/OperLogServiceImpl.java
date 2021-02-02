package com.keqi.seed.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.seed.sys.domain.db.OperLogDO;
import com.keqi.seed.sys.domain.param.OperLogParam;
import com.keqi.seed.sys.mapper.OperLogMapper;
import com.keqi.seed.sys.service.OperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OperLogServiceImpl implements OperLogService {

	@Autowired
	private OperLogMapper operLogMapper;

	@Override
	@Transactional
	public void insert(OperLogParam param) {
		OperLogDO t = BeanUtil.copyProperties(param, OperLogDO.class);


		this.operLogMapper.insert(t);
	}
}
