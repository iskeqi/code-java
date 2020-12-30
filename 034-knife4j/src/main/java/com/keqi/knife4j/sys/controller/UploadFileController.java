package com.keqi.knife4j.sys.controller;

import cn.hutool.core.io.IoUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicResponseParameters;
import com.keqi.knife4j.core.exception.BusinessException;
import com.keqi.knife4j.core.pojo.CommonConstant;
import com.keqi.knife4j.core.util.CommonUtil;
import com.keqi.knife4j.sys.domain.db.UploadFileDO;
import com.keqi.knife4j.sys.service.UploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Api(tags = "3. 文件管理")
@ApiSupport(order = 3)
@AllArgsConstructor
@Controller
public class UploadFileController {

	private final UploadFileService uploadFileService;

	@ApiOperation(value = "3.1 私有文件上传", notes = "通过此接口上传的文件，下载时需要鉴权")
	@ApiOperationSupport(order = 1)
	@DynamicResponseParameters(properties = {
			@DynamicParameter(name = "id", value = "文件ID", example = "28")
	})
	@ResponseBody
	@PostMapping("/sys/uploadFile/privateFileUpload")
	public Map<String, Object> privateFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		// 基础路径
		String basePath = CommonUtil.getApplicationHomeAbsolutePath() + CommonConstant.UPLOAD_FILE_PRIVATE_FILE;
		// 相对路径
		String relativePath = LocalDate.now() + "/" + file.getContentType() + "/";
		// 全路径
		String fullPath = basePath + relativePath;
		// 对用户上传过来的文件使用UUID进行重命名，下载时截取掉UUID这段名称即可
		String name = UUID.randomUUID().toString() + file.getOriginalFilename();

		File f = new File(fullPath, name);
		if (!f.exists()) {
			f.mkdirs();
		}
		file.transferTo(f);

		UploadFileDO t = new UploadFileDO();
		t.setName(name);
		t.setSize(file.getSize());
		t.setPath(relativePath);
		t.setType(file.getContentType());
		this.uploadFileService.insert(t);

		Map<String, Object> result = new HashMap<>();
		result.put("id", t.getId());

		return result;
	}

	@ApiOperation(value = "3.2 私有文件下载", notes = "此接口只能下载到通过私有文件上传接口上传的文件")
	@ApiOperationSupport(order = 2)
	@ApiImplicitParam(name = "id", value = "文件ID", example = "1", required = true)
	@GetMapping("/sys/uploadFile/downloadById")
	public void downloadById(HttpServletRequest request, HttpServletResponse response, @RequestParam Long id) throws Exception {
		UploadFileDO uploadFileDO = this.uploadFileService.getById(id);
		if (uploadFileDO == null) {
			throw new BusinessException("文件不存在");
		}
		String path = CommonUtil.getApplicationHomeAbsolutePath() + CommonConstant.UPLOAD_FILE_PRIVATE_FILE
				+ uploadFileDO.getPath() + uploadFileDO.getName();

		response.setCharacterEncoding(request.getCharacterEncoding());
		response.setContentType("application/octet-stream");

		BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(new File(path)));

		// 截取出 name 属性 [37,length-1) 位置的字符串，文件的真正命名
		String fileName = URLEncoder.encode(uploadFileDO.getName().substring(37), request.getCharacterEncoding());

		response.setHeader("Content-disposition", "attachment;filename=" + fileName);
		IoUtil.copy(inputStream, response.getOutputStream());
		response.flushBuffer();

		inputStream.close();
	}

	@ApiOperation(value = "3.3 私有文件删除", notes = "此接口只能删除通过私有文件上传接口上传的文件")
	@ApiOperationSupport(order = 3)
	@ApiImplicitParam(name = "id", value = "文件ID", example = "1", required = true)
	@ResponseBody
	@PostMapping("/sys/uploadFile/deleteById")
	public void deleteById(@RequestParam Long id) {
		UploadFileDO uploadFileDO = this.uploadFileService.getById(id);
		if (uploadFileDO == null) {
			throw new BusinessException("文件不存在");
		}
		String path = CommonUtil.getApplicationHomeAbsolutePath() + CommonConstant.UPLOAD_FILE_PRIVATE_FILE
				+ uploadFileDO.getPath() + uploadFileDO.getName();

		File file = new File(path);
		if (!file.delete()) {
			throw new BusinessException("文件删除失败");
		}
		this.uploadFileService.deleteById(id);
	}

	@ApiOperation(value = "3.4 公开文件上传", notes = "通过此接口上传的文件，下载时无需鉴权，可以直接通过返回的 URL 路径访问")
	@ApiOperationSupport(order = 4)
	@DynamicResponseParameters(properties = {
			@DynamicParameter(name = "path", value = "文件路径", example = "/publicFile/2020-12-24/image/png/ff289c4e-8547-4abf-a90a-ead4139a3b0ca.png")
	})
	@ResponseBody
	@PostMapping("/sys/uploadFile/publicFileUpload")
	public Map<String, Object> publicFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		// 基础路径
		String basePath = CommonUtil.getApplicationHomeAbsolutePath() + CommonConstant.UPLOAD_FILE_PUBLIC_FILE;
		// 相对路径
		String relativePath = LocalDate.now() + "/" + file.getContentType() + "/";
		// 全路径
		String fullPath = basePath + relativePath;
		// 对用户上传过来的文件使用UUID进行重命名，下载时截取掉UUID这段名称即可
		String name = UUID.randomUUID().toString() + file.getOriginalFilename();

		File f = new File(fullPath, name);
		if (!f.exists()) {
			f.mkdirs();
		}
		file.transferTo(f);

		Map<String, Object> result = new HashMap<>();
		result.put("path", "/publicFile/" + relativePath + name);

		return result;
	}

}
