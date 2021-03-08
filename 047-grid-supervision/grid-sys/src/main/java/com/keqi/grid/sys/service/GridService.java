package com.keqi.grid.sys.service;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.GridPageParam;
import com.keqi.grid.sys.domain.param.GridParam;
import com.keqi.grid.sys.domain.vo.GridVO;

public interface GridService {

	void insert(GridParam param);

	void updateById(GridParam param);

	void deleteById(Long id);

	PageVO<GridVO> page(GridPageParam param);
}