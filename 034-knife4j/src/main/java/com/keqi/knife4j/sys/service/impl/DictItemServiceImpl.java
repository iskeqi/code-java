package com.keqi.knife4j.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.db.DictItemDO;
import com.keqi.knife4j.sys.domain.param.DictItemPageParam;
import com.keqi.knife4j.sys.domain.param.DictItemParam;
import com.keqi.knife4j.sys.domain.vo.DictItemVO;
import com.keqi.knife4j.sys.mapper.DictItemMapper;
import com.keqi.knife4j.sys.service.DictItemService;
import com.keqi.knife4j.sys.util.DictUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class DictItemServiceImpl implements DictItemService {

	private final DictItemMapper dictItemMapper;
	private final DictUtil dictUtil;

	/**
	 * 新增字典项
	 *
	 * @param param param
	 */
	@Override
	@Transactional
	public void insert(DictItemParam param) {
		DictItemDO t = new DictItemDO();
		BeanUtils.copyProperties(param, t);
		this.dictItemMapper.insert(t);

		this.dictUtil.run();
	}

	/**
	 * 修改字典项
	 *
	 * @param param param
	 */
	@Override
	@Transactional
	public void updateById(DictItemParam param) {
		DictItemDO t = new DictItemDO();
		BeanUtils.copyProperties(param, t);
		this.dictItemMapper.updateById(t);

		this.dictUtil.run();
	}

	/**
	 * 删除字典项
	 *
	 * @param id id
	 */
	@Override
	@Transactional
	public void deleteById(Long id) {
		// 逻辑删除
		this.dictItemMapper.disableById(id);

		this.dictUtil.run();
	}

	/**
	 * 分页查询字典项列表
	 *
	 * @param param param
	 * @return r
	 */
	@Override
	public PageVO<DictItemVO> page(DictItemPageParam param) {
		IPage<DictItemVO> result = this.dictItemMapper
				.page(new Page<>(param.getCurrent(), param.getSize()), param);
		return new PageVO<>(result.getTotal(), result.getRecords());
	}

	/**
	 * 根据 typeCode 查询字典项列表
	 *
	 * @param typeCode typeCode
	 * @return r
	 */
	@Override
	public List<DictItemVO> listAllByTypeCode(String typeCode) {
		return this.dictItemMapper.listAllByTypeCode(typeCode);
	}
}
