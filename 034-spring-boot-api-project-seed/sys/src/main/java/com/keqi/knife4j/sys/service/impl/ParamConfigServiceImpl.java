package com.keqi.knife4j.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.db.ParamConfigDO;
import com.keqi.knife4j.sys.domain.param.ParamConfigPageParam;
import com.keqi.knife4j.sys.domain.param.ParamConfigParam;
import com.keqi.knife4j.sys.domain.vo.ParamConfigVO;
import com.keqi.knife4j.sys.mapper.ParamConfigMapper;
import com.keqi.knife4j.sys.service.ParamConfigService;
import com.keqi.knife4j.sys.util.DictUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ParamConfigServiceImpl implements ParamConfigService {

	@Autowired
	private ParamConfigMapper paramConfigMapper;

	@Override
	@Transactional
	public void insert(ParamConfigParam param) {
		ParamConfigDO t = BeanUtil.copyProperties(param, ParamConfigDO.class);
		this.paramConfigMapper.insert(t);
	}

	@Override
	@Transactional
	public void updateById(ParamConfigParam param) {
		ParamConfigDO t = BeanUtil.copyProperties(param, ParamConfigDO.class);
		this.paramConfigMapper.updateById(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.paramConfigMapper.deleteById(id);
	}

	@Override
	public PageVO<ParamConfigVO> page(ParamConfigPageParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		List<ParamConfigVO> result = this.paramConfigMapper.page(param);

		for (ParamConfigVO t : result) {
			t.setParamTypeName(DictUtil.getItemName(t.getParamType()));
		}

		return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
	}
}
