package com.keqi.grid.sys.service.impl;

import cn.hutool.core.io.IoUtil;
import com.keqi.grid.core.exception.BusinessException;
import com.keqi.grid.sys.domain.db.UploadFileDO;
import com.keqi.grid.sys.mapper.UploadFileMapper;
import com.keqi.grid.sys.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements UploadFileService {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UploadFileServiceImpl.class);

	@Autowired
	private UploadFileMapper uploadFileMapper;

	@Override
	@Transactional
	public String upload(MultipartFile file) {
		String basePath = new ApplicationHome().getDir().getAbsolutePath() + File.separator + "uploadFile" + File.separator;
		String relativePath = LocalDate.now() + File.separator;
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
		this.uploadFileMapper.insert(t);
		return null;
	}

	@Override
	@Transactional
	public void deleteByFileName(String fileName) {
		UploadFileDO uploadFileDO = this.uploadFileMapper.find(new UploadFileDO(fileName));
		if (uploadFileDO == null) {
			throw new BusinessException("文件不存在");
		}
		String path = new ApplicationHome().getDir().getAbsolutePath() + File.separator + "uploadFile" + File.separator
				+ uploadFileDO.getPath() + uploadFileDO.getName();

		File file = new File(path);
		if (!file.delete()) {
			throw new BusinessException("文件删除失败");
		}

		this.uploadFileMapper.deleteById(uploadFileDO.getId());
	}

	@Override
	public void downloadByName(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException {
		UploadFileDO uploadFileDO = this.uploadFileMapper.find(new UploadFileDO(fileName));
		if (uploadFileDO == null) {
			throw new BusinessException("文件不存在");
		}
		String path = new ApplicationHome().getDir().getAbsolutePath() + File.separator + "uploadFile" + File.separator
				+ uploadFileDO.getPath() + uploadFileDO.getName();

		response.setCharacterEncoding(request.getCharacterEncoding());
		response.setContentType("application/octet-stream");

		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(path));

		String name = URLEncoder.encode(uploadFileDO.getName().substring(fileName.indexOf("-") + 1), request.getCharacterEncoding());

		response.setHeader("Content-disposition", "attachment;filename=" + name);
		IoUtil.copy(inputStream, response.getOutputStream());
		response.flushBuffer();

		inputStream.close();
	}
}
