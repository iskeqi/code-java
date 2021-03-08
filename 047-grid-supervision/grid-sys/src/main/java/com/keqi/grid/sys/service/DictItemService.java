package com.keqi.grid.sys.service;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.DictItemPageParam;
import com.keqi.grid.sys.domain.param.DictItemParam;
import com.keqi.grid.sys.domain.vo.DictItemVO;

public interface DictItemService {

	void insert(DictItemParam param);

	void updateById(DictItemParam param);

	void deleteById(Long id);

	PageVO<DictItemVO> page(DictItemPageParam param);
}