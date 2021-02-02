package com.keqi.seed.sys.service;

import com.keqi.seed.sys.domain.db.UploadFileDO;
import com.keqi.seed.sys.domain.vo.PrivateFileUploadVO;
import com.keqi.seed.sys.domain.vo.PublicFileUploadVO;
import org.springframework.web.multipart.MultipartFile;

public interface UploadFileService {

	void insert(UploadFileDO t);

	void deleteByName(String name);

	PrivateFileUploadVO privateFileUpload(MultipartFile file);

	PublicFileUploadVO publicFileUpload(MultipartFile file);

	UploadFileDO selectByName(String name);
}
