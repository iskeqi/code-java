package com.keqi.grid.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.db.GridAccountDO;
import com.keqi.grid.sys.domain.param.GridAccountPageParam;
import com.keqi.grid.sys.domain.param.GridAccountParam;
import com.keqi.grid.sys.domain.vo.GridAccountVO;
import com.keqi.grid.sys.mapper.GridAccountMapper;
import com.keqi.grid.sys.service.GridAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GridAccountServiceImpl implements GridAccountService {

	@Autowired
	private GridAccountMapper gridAccountMapper;

	@Override
	@Transactional
	public void insert(GridAccountParam param) {
		GridAccountDO t = BeanUtil.copyProperties(param, GridAccountDO.class);
		this.gridAccountMapper.insert(t);
	}

	@Override
	@Transactional
	public void updateById(GridAccountParam param) {
		GridAccountDO t = BeanUtil.copyProperties(param, GridAccountDO.class);
		this.gridAccountMapper.updateById(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.gridAccountMapper.deleteById(id);
	}

	@Override
	public PageVO<GridAccountVO> page(GridAccountPageParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		// List<GridAccountVO> result = this.gridAccountMapper.page(param);

		// return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
		return null;
	}
}
