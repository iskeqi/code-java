package com.keqi.knife4j.sys.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.db.DictItemDO;
import com.keqi.knife4j.sys.domain.param.DictItemPageParam;
import com.keqi.knife4j.sys.domain.param.DictItemParam;
import com.keqi.knife4j.sys.domain.vo.DictItemVO;
import com.keqi.knife4j.sys.mapper.DictItemMapper;
import com.keqi.knife4j.sys.service.DictItemService;
import com.keqi.knife4j.sys.util.DictUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DictItemServiceImpl implements DictItemService {

	@Autowired
	private DictItemMapper dictItemMapper;
	@Autowired
	private DictUtil dictUtil;

	@Override
	@Transactional
	public void insert(DictItemParam param) {
		DictItemDO t = new DictItemDO();
		BeanUtils.copyProperties(param, t);
		this.dictItemMapper.insert(t);

		this.dictUtil.run();
	}

	@Override
	@Transactional
	public void updateById(DictItemParam param) {
		DictItemDO t = new DictItemDO();
		BeanUtils.copyProperties(param, t);
		this.dictItemMapper.updateById(t);

		this.dictUtil.run();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.dictItemMapper.deleteById(id);

		this.dictUtil.run();
	}

	@Override
	public PageVO<DictItemVO> page(DictItemPageParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<DictItemVO> result = this.dictItemMapper.page(param);

		return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
	}

	/**
	 * 根据 typeCode 查询字典项列表
	 *
	 * @param typeCode typeCode
	 * @return r
	 */
	@Override
	public List<DictItemVO> selectByTypeCode(String typeCode) {
		return this.dictItemMapper.selectByTypeCode(typeCode);
	}
}
