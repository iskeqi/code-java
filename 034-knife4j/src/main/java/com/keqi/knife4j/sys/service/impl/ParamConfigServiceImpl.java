package com.keqi.knife4j.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.db.ParamConfigDO;
import com.keqi.knife4j.sys.domain.param.ParamConfigPageParam;
import com.keqi.knife4j.sys.domain.param.ParamConfigParam;
import com.keqi.knife4j.sys.domain.vo.ParamConfigVO;
import com.keqi.knife4j.sys.mapper.ParamConfigMapper;
import com.keqi.knife4j.sys.service.ParamConfigService;
import com.keqi.knife4j.sys.util.DictUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ParamConfigServiceImpl implements ParamConfigService {

	private final ParamConfigMapper paramConfigMapper;

	/**
	 * 新增参数配置
	 *
	 * @param paramConfigParam paramConfigParam
	 */
	@Override
	@Transactional
	public void insert(ParamConfigParam paramConfigParam) {
		ParamConfigDO t = new ParamConfigDO();
		BeanUtil.copyProperties(paramConfigParam, t);

		this.paramConfigMapper.insert(t);
	}

	/**
	 * 根据ID修改参数配置
	 *
	 * @param paramConfigParam paramConfigParam
	 */
	@Override
	@Transactional
	public void updateById(ParamConfigParam paramConfigParam) {
		ParamConfigDO t = new ParamConfigDO();
		BeanUtil.copyProperties(paramConfigParam, t);

		this.paramConfigMapper.updateById(t);
	}

	/**
	 * 根据ID删除参数配置
	 *
	 * @param id id
	 */
	@Override
	@Transactional
	public void deleteById(Long id) {
		this.paramConfigMapper.deleteById(id);
	}

	/**
	 * 分页查询参数配置列表
	 *
	 * @param pageParam pageParam
	 * @return r
	 */
	@Override
	public PageVO<ParamConfigVO> page(ParamConfigPageParam pageParam) {
		Page<ParamConfigVO> page = new Page<>(pageParam.getCurrent(), pageParam.getSize());
		IPage<ParamConfigVO> result = this.paramConfigMapper.page(page, pageParam);
		for (ParamConfigVO t : result.getRecords()) {
			t.setParamTypeName(DictUtil.getItemName(t.getParamType()));
		}

		return new PageVO<>(result.getTotal(), result.getRecords());
	}
}
