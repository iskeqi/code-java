package com.keqi.grid.sys.controller;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.UploadFilePageParam;
import com.keqi.grid.sys.domain.param.UploadFileParam;
import com.keqi.grid.sys.domain.vo.UploadFileVO;
import com.keqi.grid.sys.service.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UploadFileController {

	@Autowired
	private UploadFileService uploadFileService;

	@PostMapping("/sys/uploadFile")
	public void insert(@Validated @RequestBody UploadFileParam param) {
		this.uploadFileService.insert(param);
	}

	@PutMapping("/sys/uploadFile")
	public void updateById(@Validated @RequestBody UploadFileParam param) {
		this.uploadFileService.updateById(param);
	}

	@DeleteMapping("/sys/uploadFile/{id}")
	public void deleteById(@PathVariable Long id) {
		this.uploadFileService.deleteById(id);
	}

	@PostMapping("/sys/uploadFile/page")
	public PageVO<UploadFileVO> page(@RequestBody UploadFilePageParam param) {
		return this.uploadFileService.page(param);
	}
}