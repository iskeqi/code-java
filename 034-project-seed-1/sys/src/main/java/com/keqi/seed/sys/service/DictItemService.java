package com.keqi.seed.sys.service;

import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.param.DictItemPageParam;
import com.keqi.seed.sys.domain.param.DictItemParam;
import com.keqi.seed.sys.domain.vo.DictItemVO;

import java.util.List;

public interface DictItemService {

	void insert(DictItemParam param);

	void updateById(DictItemParam param);

	void deleteById(Long id);

	PageVO<DictItemVO> page(DictItemPageParam param);

	List<DictItemVO> selectByTypeCode(String typeCode);
}
