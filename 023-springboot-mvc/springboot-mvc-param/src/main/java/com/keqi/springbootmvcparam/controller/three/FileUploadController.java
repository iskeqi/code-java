/*
package com.keqi.springbootmvcparam.controller.three;

import com.keqi.springbootmvcparam.common.AjaxEntity;
import com.keqi.springbootmvcparam.common.AjaxEntityBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

	@PostMapping("/sys/upload")
	public AjaxEntity upload(@RequestParam("file") MultipartFile file, @RequestParam("id") Long id) {
		try {
			// 文件上传的同时，也是可以同时传递请求参数的，服务端只需要使用 @RequestParam 注解接收即可
			// Content-type 必须是 Multipart/form-data
			// 可以同时接收多个文件，只需要使用 MultipartFile[] 即可
			// 要想熟练掌握文件上传的各种使用技巧，其实只需要 MultipartFile 类的 API 即可
			file.transferTo(new File("D://xxx"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return AjaxEntityBuilder.success();
	}
}
*/
