package com.keqi.knife4j.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.keqi.knife4j.sys.domain.db.OperLogDO;
import com.keqi.knife4j.sys.domain.param.OperLogParam;
import com.keqi.knife4j.sys.mapper.OperLogMapper;
import com.keqi.knife4j.sys.service.OperLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class OperLogServiceImpl implements OperLogService {

	private final OperLogMapper operLogMapper;

	/**
	 * 新增操作日志记录
	 *
	 * @param param param
	 */
	@Override
	@Transactional
	public void insert(OperLogParam param) {
		OperLogDO t = new OperLogDO();
		BeanUtil.copyProperties(param, t);

		this.operLogMapper.insert(t);
	}
}
