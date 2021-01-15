package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.ParamConfigPageParam;
import com.keqi.knife4j.sys.domain.param.ParamConfigParam;
import com.keqi.knife4j.sys.domain.vo.ParamConfigVO;

public interface ParamConfigService {

	/**
	 * 新增参数配置
	 *
	 * @param param param
	 */
	void insert(ParamConfigParam param);

	/**
	 * 修改参数配置
	 *
	 * @param param param
	 */
	void updateById(ParamConfigParam param);

	/**
	 * 删除参数配置
	 *
	 * @param id id
	 */
	void deleteById(Long id);

	/**
	 * 分页查询参数配置列表
	 *
	 * @param param param
	 * @return r
	 */
	PageVO<ParamConfigVO> page(ParamConfigPageParam param);
}