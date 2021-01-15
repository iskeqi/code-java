package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.sys.domain.param.OperLogParam;

public interface OperLogService {

	/**
	 * 新增操作日志记录
	 *
	 * @param param param
	 */
	void insert(OperLogParam param);
}
