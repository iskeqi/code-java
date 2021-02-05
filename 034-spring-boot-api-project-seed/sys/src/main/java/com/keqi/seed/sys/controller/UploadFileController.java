package com.keqi.seed.sys.controller;

import cn.hutool.core.io.IoUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.seed.core.web.exception.BusinessException;
import com.keqi.seed.core.pojo.CoreConstant;
import com.keqi.seed.core.util.CommonUtil;
import com.keqi.seed.sys.domain.db.UploadFileDO;
import com.keqi.seed.sys.domain.vo.PrivateFileUploadVO;
import com.keqi.seed.sys.domain.vo.PublicFileUploadVO;
import com.keqi.seed.sys.service.UploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URLEncoder;

@Api(tags = "3. 文件管理")
@ApiSupport(order = 3)
@Controller
public class UploadFileController {

	@Autowired
	private UploadFileService uploadFileService;

	@ApiOperation(value = "3.1 私有文件上传", notes = "通过此接口上传的文件，下载时需要鉴权")
	@ApiOperationSupport(order = 1)
	@ResponseBody
	@PostMapping("/sys/uploadFile/privateFileUpload")
	public PrivateFileUploadVO privateFileUpload(@RequestParam("file") MultipartFile file) {
		return this.uploadFileService.privateFileUpload(file);
	}

	@ApiOperation(value = "3.2 私有文件下载", notes = "此接口只能下载到通过私有文件上传接口上传的文件")
	@ApiOperationSupport(order = 2)
	@ApiImplicitParam(name = "name", value = "文件名称", example = "94a1679b62ea46ca82216d026f00b5b6-Java开发手册（嵩山版）.pdf", required = true)
	@GetMapping("/sys/uploadFile/downloadByName")
	public void downloadByName(HttpServletRequest request, HttpServletResponse response, @RequestParam String name) throws Exception {
		UploadFileDO uploadFileDO = this.uploadFileService.selectByName(name);
		if (uploadFileDO == null) {
			throw new BusinessException("文件不存在");
		}
		String path = CommonUtil.getApplicationHomeAbsolutePath() + CoreConstant.UPLOAD_FILE_PRIVATE_FILE
				+ uploadFileDO.getPath() + uploadFileDO.getName();

		response.setCharacterEncoding(request.getCharacterEncoding());
		response.setContentType("application/octet-stream");

		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(path));

		String fileName = URLEncoder.encode(uploadFileDO.getName().substring(name.indexOf("-") + 1), request.getCharacterEncoding());

		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		IoUtil.copy(inputStream, response.getOutputStream());
		response.flushBuffer();

		inputStream.close();
	}

	@ApiOperation(value = "3.3 私有文件删除", notes = "此接口只能删除通过私有文件上传接口上传的文件")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "name", value = "文件名称", example = "94a1679b62ea46ca82216d026f00b5b6-Java开发手册（嵩山版）.pdf", required = true)
	@ResponseBody
	@DeleteMapping("/sys/uploadFile/{name}")
	public void deleteByName(@PathVariable String name) {
		this.uploadFileService.deleteByName(name);
	}

	@ApiOperation(value = "3.4 公开文件上传", notes = "通过此接口上传的文件，下载时无需鉴权，可以直接通过返回的 URL 路径访问")
	@ApiOperationSupport(order = 4)
	@ResponseBody
	@PostMapping("/sys/uploadFile/publicFileUpload")
	public PublicFileUploadVO publicFileUpload(@RequestParam("file") MultipartFile file) {
		return this.uploadFileService.publicFileUpload(file);
	}

}
