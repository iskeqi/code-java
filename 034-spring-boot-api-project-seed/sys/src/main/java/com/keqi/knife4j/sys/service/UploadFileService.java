package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.sys.domain.db.UploadFileDO;
import com.keqi.knife4j.sys.domain.vo.PrivateFileUploadVO;
import com.keqi.knife4j.sys.domain.vo.PublicFileUploadVO;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {

	void insert(UploadFileDO t);

	void deleteByName(String name);

	PrivateFileUploadVO privateFileUpload(MultipartFile file);

	PublicFileUploadVO publicFileUpload(MultipartFile file);

	UploadFileDO selectByName(String name);
}
