package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.ParamConfigPageParam;
import com.keqi.knife4j.sys.domain.param.ParamConfigParam;
import com.keqi.knife4j.sys.domain.vo.ParamConfigVO;

public interface ParamConfigService {

	/**
	 * 新增参数配置
	 *
	 * @param paramConfigParam paramConfigParam
	 */
	void insert(ParamConfigParam paramConfigParam);

	/**
	 * 根据ID修改参数配置
	 *
	 * @param paramConfigParam paramConfigParam
	 */
	void updateById(ParamConfigParam paramConfigParam);

	/**
	 * 根据ID删除参数配置
	 *
	 * @param id id
	 */
	void deleteById(Long id);

	/**
	 * 分页查询参数配置列表
	 *
	 * @param pageParam pageParam
	 * @return r
	 */
	PageVO<ParamConfigVO> page(ParamConfigPageParam pageParam);
}