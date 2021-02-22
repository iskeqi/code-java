package com.keqi.seed.sys.service;

import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.param.ParamConfigPageParam;
import com.keqi.seed.sys.domain.param.ParamConfigParam;
import com.keqi.seed.sys.domain.vo.ParamConfigVO;

public interface ParamConfigService {

	void insert(ParamConfigParam param);

	void updateById(ParamConfigParam param);

	void deleteById(Long id);

	PageVO<ParamConfigVO> page(ParamConfigPageParam param);
}