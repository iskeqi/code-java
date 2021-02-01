package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.sys.domain.db.UploadFileDO;
import com.keqi.knife4j.sys.domain.vo.PrivateFileUploadVO;
import com.keqi.knife4j.sys.domain.vo.PublicFileUploadVO;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {

	void insert(UploadFileDO t);

	void deleteByName(String name);

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

	UploadFileDO getByName(String name);
}
