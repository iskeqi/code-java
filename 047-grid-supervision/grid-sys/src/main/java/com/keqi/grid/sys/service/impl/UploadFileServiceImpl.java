package com.keqi.grid.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageSerializable;
import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.db.UploadFileDO;
import com.keqi.grid.sys.domain.param.UploadFilePageParam;
import com.keqi.grid.sys.domain.param.UploadFileParam;
import com.keqi.grid.sys.domain.vo.UploadFileVO;
import com.keqi.grid.sys.mapper.UploadFileMapper;
import com.keqi.grid.sys.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UploadFileServiceImpl implements UploadFileService {

	@Autowired
	private UploadFileMapper uploadFileMapper;

	@Override
	@Transactional
	public void insert(UploadFileParam param) {
		UploadFileDO t = BeanUtil.copyProperties(param, UploadFileDO.class);
		this.uploadFileMapper.insert(t);
	}

	@Override
	@Transactional
	public void updateById(UploadFileParam param) {
		UploadFileDO t = BeanUtil.copyProperties(param, UploadFileDO.class);
		this.uploadFileMapper.updateById(t);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		this.uploadFileMapper.deleteById(id);
	}

	@Override
	public PageVO<UploadFileVO> page(UploadFilePageParam param) {
		PageHelper.startPage(param.getPageNum(), param.getPageSize());
		// List<UploadFileVO> result = this.uploadFileMapper.page(param);

		// return new PageVO<>(new PageSerializable<>(result).getTotal(), result);
		return null;
	}
}
