package com.keqi.grid.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.db.DictItemDO;
import com.keqi.grid.sys.domain.param.DictItemPageParam;
import com.keqi.grid.sys.domain.param.DictItemParam;
import com.keqi.grid.sys.domain.vo.DictItemVO;
import com.keqi.grid.sys.mapper.DictItemMapper;
import com.keqi.grid.sys.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DictItemServiceImpl implements DictItemService {

	@Autowired
	private DictItemMapper dictItemMapper;

	@Override
	@Transactional
	public void insert(DictItemParam param) {
		DictItemDO t = BeanUtil.copyProperties(param, DictItemDO.class);
		this.dictItemMapper.insert(t);
	}

	@Override
	@Transactional
	public void updateById(DictItemParam param) {
		DictItemDO t = BeanUtil.copyProperties(param, DictItemDO.class);
		this.dictItemMapper.updateById(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.dictItemMapper.deleteById(id);
	}

	@Override
	public PageVO<DictItemVO> page(DictItemPageParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		// List<DictItemVO> result = this.dictItemMapper.page(param);

		// return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
		return null;
	}
}
