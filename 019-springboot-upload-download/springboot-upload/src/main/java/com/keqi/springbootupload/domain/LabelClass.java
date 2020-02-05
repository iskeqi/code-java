package com.keqi.springbootupload.domain;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author keqi
 */
public class LabelClass {

	private String name;

	private MultipartFile uploadFile;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
}
