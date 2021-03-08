package com.keqi.grid.sys.service;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.GridAccountPageParam;
import com.keqi.grid.sys.domain.param.GridAccountParam;
import com.keqi.grid.sys.domain.vo.GridAccountVO;

public interface GridAccountService {

	void insert(GridAccountParam param);

	void updateById(GridAccountParam param);

	void deleteById(Long id);

	PageVO<GridAccountVO> page(GridAccountPageParam param);
}