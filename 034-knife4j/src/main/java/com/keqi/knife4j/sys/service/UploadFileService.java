package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.sys.domain.db.UploadFileDO;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {

	/**
	 * 增加
	 *
	 * @param t t
	 */
	void insert(UploadFileDO t);

	/**
	 * 获取对象
	 *
	 * @param id id
	 * @return r
	 */
	UploadFileDO getById(Long id);

	/**
	 * 删除文件
	 *
	 * @param id id
	 */
	void deleteById(Long id);

	/**
	 * 根据 id 获取文件名称（去除了 UUID 前缀的文件名）
	 *
	 * @param id id
	 * @return r
	 */
	String getSimpleNameById(Long id);

	/**
	 * 私有文件上传
	 *
	 * @param file file
	 * @return r
	 */
	Long privateFileUpload(MultipartFile file);

	/**
	 * 公开文件上传
	 *
	 * @param file file
	 * @return r
	 */
	String publicFileUpload(MultipartFile file);
}
