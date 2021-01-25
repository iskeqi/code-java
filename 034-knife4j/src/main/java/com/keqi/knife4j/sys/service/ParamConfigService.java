package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.ParamConfigPageParam;
import com.keqi.knife4j.sys.domain.param.ParamConfigParam;
import com.keqi.knife4j.sys.domain.vo.ParamConfigVO;

public interface ParamConfigService {

	void insert(ParamConfigParam param);

	void updateById(ParamConfigParam param);

	void deleteById(Long id);

	PageVO<ParamConfigVO> page(ParamConfigPageParam param);
}