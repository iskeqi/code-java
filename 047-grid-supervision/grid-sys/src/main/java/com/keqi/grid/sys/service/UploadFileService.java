package com.keqi.grid.sys.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UploadFileService {

	String upload(MultipartFile file);

	void deleteByFileName(String fileName);

	void downloadByName(HttpServletRequest request, HttpServletResponse response, String fileName) throws IOException;
}