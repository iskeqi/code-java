package com.keqi.seed.sys.service.impl;

import com.keqi.seed.core.web.exception.BusinessException;
import com.keqi.seed.core.pojo.CoreConstant;
import com.keqi.seed.core.util.CommonUtil;
import com.keqi.seed.sys.domain.db.UploadFileDO;
import com.keqi.seed.sys.domain.vo.PrivateFileUploadVO;
import com.keqi.seed.sys.domain.vo.PublicFileUploadVO;
import com.keqi.seed.sys.mapper.UploadFileMapper;
import com.keqi.seed.sys.service.UploadFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@Service
public class UploadFileServiceImpl implements UploadFileService {

	@Autowired
	private UploadFileMapper uploadFileMapper;

	@Override
	@Transactional
	public void insert(UploadFileDO t) {
		this.uploadFileMapper.insert(t);
	}

	@Override
	@Transactional
	public void deleteByName(String name) {
		UploadFileDO uploadFileDO = this.uploadFileMapper.selectByName(name);
		if (uploadFileDO == null) {
			throw new BusinessException("文件不存在");
		}
		String path = CommonUtil.getApplicationHomeAbsolutePath() + CoreConstant.UPLOAD_FILE_PRIVATE_FILE
				+ uploadFileDO.getPath() + uploadFileDO.getName();

		File file = new File(path);
		if (!file.delete()) {
			throw new BusinessException("文件删除失败");
		}

		this.uploadFileMapper.deleteById(uploadFileDO.getId());
	}

	/**
	 * 私有文件上传
	 *
	 * @param file file
	 * @return r
	 */
	@Override
	public PrivateFileUploadVO privateFileUpload(MultipartFile file) {
		String basePath = CommonUtil.getApplicationHomeAbsolutePath() + CoreConstant.UPLOAD_FILE_PRIVATE_FILE;
		String relativePath = LocalDate.now() + File.separator + file.getContentType() + File.separator;
		String fullPath = basePath + relativePath;
		String name = UUID.randomUUID().toString().replace("-", "") + "-" + file.getOriginalFilename();

		File path = new File(fullPath);
		if (!path.exists()) {
			path.mkdirs();
		}

		try {
			file.transferTo(new File(fullPath, name));
		} catch (IOException e) {
			log.info(e.getMessage(), e);
			throw new BusinessException("文件上传失败");
		}

		UploadFileDO t = new UploadFileDO();
		t.setName(name);
		t.setSize(file.getSize());
		t.setPath(relativePath);
		t.setType(file.getContentType());
		this.insert(t);

		PrivateFileUploadVO vo = new PrivateFileUploadVO();
		vo.setName(name);
		return vo;
	}

	@Override
	public PublicFileUploadVO publicFileUpload(MultipartFile file) {
		String basePath = CommonUtil.getApplicationHomeAbsolutePath() + CoreConstant.UPLOAD_FILE_PUBLIC_FILE;
		String relativePath = LocalDate.now() + File.separator + file.getContentType() + File.separator;
		String fullPath = basePath + relativePath;
		String name = UUID.randomUUID().toString() + file.getOriginalFilename();

		File path = new File(fullPath);
		if (!path.exists()) {
			path.mkdirs();
		}

		try {
			file.transferTo(new File(fullPath, name));
		} catch (IOException e) {
			log.info(e.getMessage(), e);
			throw new BusinessException("文件上传失败");
		}

		PublicFileUploadVO vo = new PublicFileUploadVO();
		vo.setPath(relativePath + name);
		return vo;
	}

	@Override
	public UploadFileDO selectByName(String name) {
		return this.uploadFileMapper.selectByName(name);
	}
}
