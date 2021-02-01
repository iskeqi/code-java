package com.keqi.knife4j.sys.service.impl;

import com.keqi.knife4j.core.exception.BusinessException;
import com.keqi.knife4j.core.pojo.CommonConstant;
import com.keqi.knife4j.core.util.CommonUtil;
import com.keqi.knife4j.sys.domain.db.UploadFileDO;
import com.keqi.knife4j.sys.domain.vo.PrivateFileUploadVO;
import com.keqi.knife4j.sys.domain.vo.PublicFileUploadVO;
import com.keqi.knife4j.sys.mapper.UploadFileMapper;
import com.keqi.knife4j.sys.service.UploadFileService;
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
		String path = CommonUtil.getApplicationHomeAbsolutePath() + CommonConstant.UPLOAD_FILE_PRIVATE_FILE
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
		// 基础路径
		String basePath = CommonUtil.getApplicationHomeAbsolutePath() + CommonConstant.UPLOAD_FILE_PRIVATE_FILE;
		// 相对路径
		String relativePath = LocalDate.now() + File.separator + file.getContentType() + File.separator;
		// 全路径
		String fullPath = basePath + relativePath;
		// 对用户上传过来的文件使用UUID进行重命名，下载时截取掉UUID这段名称即可
		String name = UUID.randomUUID().toString().replace("-", "") + "-" + file.getOriginalFilename();

		// 先创建好路径
		File path = new File(fullPath);
		if (!path.exists()) {
			path.mkdirs();
		}
		// 保存文件到硬盘中的指定文件中
		try {
			file.transferTo(new File(fullPath, name));
		} catch (IOException e) {
			// 打印异常栈信息至日志文件中
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

	/**
	 * 公开文件上传
	 *
	 * @param file file
	 * @return r
	 */
	@Override
	public PublicFileUploadVO publicFileUpload(MultipartFile file) {
		// 基础路径
		String basePath = CommonUtil.getApplicationHomeAbsolutePath() + CommonConstant.UPLOAD_FILE_PUBLIC_FILE;
		// 相对路径
		String relativePath = LocalDate.now() + File.separator + file.getContentType() + File.separator;
		// 全路径
		String fullPath = basePath + relativePath;
		// 对用户上传过来的文件使用UUID进行重命名，下载时截取掉UUID这段名称即可
		String name = UUID.randomUUID().toString() + file.getOriginalFilename();

		// 先创建好路径
		File path = new File(fullPath);
		if (!path.exists()) {
			path.mkdirs();
		}
		// 保存文件到硬盘中的指定文件中
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
	public UploadFileDO getByName(String name) {
		return this.uploadFileMapper.selectByName(name);
	}
}
