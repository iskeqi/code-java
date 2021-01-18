package com.keqi.knife4j.sys.service.impl;

import com.keqi.knife4j.core.exception.BusinessException;
import com.keqi.knife4j.sys.domain.db.UploadFileDO;
import com.keqi.knife4j.sys.mapper.UploadFileMapper;
import com.keqi.knife4j.sys.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UploadFileServiceImpl implements UploadFileService {

	@Autowired
	private UploadFileMapper uploadFileMapper;

	/**
	 * 增加
	 *
	 * @param t t
	 */
	@Override
	@Transactional
	public void insert(UploadFileDO t) {
		this.uploadFileMapper.insert(t);
	}

	/**
	 * 获取对象
	 *
	 * @param id id
	 * @return r
	 */
	@Override
	public UploadFileDO getById(Long id) {
		return this.uploadFileMapper.getById(id);
	}

	/**
	 * 删除文件
	 *
	 * @param id id
	 */
	@Override
	@Transactional
	public void deleteById(Long id) {
		this.uploadFileMapper.deleteById(id);
	}

	/**
	 * 根据 id 获取文件名称（去除了 UUID 前缀的文件名）
	 *
	 * @param id id
	 * @return r
	 */
	@Override
	public String getSimpleNameById(Long id) {
		UploadFileDO t = this.uploadFileMapper.getById(id);
		if (t == null) {
			throw new BusinessException("不存在此文件");
		}
		return t.getName().substring(37);
	}
}
