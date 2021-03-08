package com.keqi.grid.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.db.GridDO;
import com.keqi.grid.sys.domain.param.GridPageParam;
import com.keqi.grid.sys.domain.param.GridParam;
import com.keqi.grid.sys.domain.vo.GridVO;
import com.keqi.grid.sys.mapper.GridMapper;
import com.keqi.grid.sys.service.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GridServiceImpl implements GridService {

	@Autowired
	private GridMapper gridMapper;

	@Override
	@Transactional
	public void insert(GridParam param) {
		GridDO t = BeanUtil.copyProperties(param, GridDO.class);
		this.gridMapper.insert(t);
	}

	@Override
	@Transactional
	public void updateById(GridParam param) {
		GridDO t = BeanUtil.copyProperties(param, GridDO.class);
		this.gridMapper.updateById(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.gridMapper.deleteById(id);
	}

	@Override
	public PageVO<GridVO> page(GridPageParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		// List<GridVO> result = this.gridMapper.page(param);

		// return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
		return null;
	}
}
