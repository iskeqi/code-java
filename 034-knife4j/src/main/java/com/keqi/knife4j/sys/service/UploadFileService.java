package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.sys.domain.db.UploadFileDO;
import com.keqi.knife4j.sys.domain.vo.PrivateFileUploadVO;
import com.keqi.knife4j.sys.domain.vo.PublicFileUploadVO;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {

	void insert(UploadFileDO t);

	void deleteById(Long id);

	/**
	 * 获取对象
	 *
	 * @param id id
	 * @return r
	 */
	UploadFileDO getById(Long id);

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
	PrivateFileUploadVO privateFileUpload(MultipartFile file);

	/**
	 * 公开文件上传
	 *
	 * @param file file
	 * @return r
	 */
	PublicFileUploadVO publicFileUpload(MultipartFile file);
}
