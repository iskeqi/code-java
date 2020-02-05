package com.keqi.springbootupload.controller;

import com.keqi.springbootupload.config.GlobalProperty;
import com.keqi.springbootupload.domain.LabelClass;
import com.keqi.springbootupload.util.ZipUtil;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @author keqi
 */
@Controller
@RequestMapping("/uploadAndDownload")
public class UploadAndDownloadFileController {

	private static final Logger logger = LoggerFactory.getLogger(UploadAndDownloadFileController.class);

	@Autowired
	private GlobalProperty globalProperty;

	@Autowired
	private Environment environment;

	@RequestMapping("/index")
	public String index() {
		return "uploadAndDownload";
	}

	/**
	 * 下载示例(如果文件下载需要权限控制，在必须要)
	 *
	 * @param request
	 * @param response
	 */
	@GetMapping("/downloadFileAction")
	public void downloadFileAction(HttpServletRequest request, HttpServletResponse response) {

		response.setCharacterEncoding(request.getCharacterEncoding());
		response.setContentType("application/octet-stream");
		InputStream fis = null;
		try {
			// 一定记得把文件放在自己新建的目录下放着，不然路径就找不到
			ClassPathResource classPathResource = new ClassPathResource("zipTemplate/image.zip");
			fis = classPathResource.getInputStream();

			// 那如果我非要保证用户下载的时候下载到的是一个有具体中文命名的文档怎么办呢？
			// 其实可以通过把中文进行编码转成英文，传递给前端，然后前端再解码就行了啊，前后端约定好用什么编码方式就行
			// 直接使用java.net.URLEncoder类的encode()方法进行编码就行
			String fileName = URLEncoder.encode("image.zip", request.getCharacterEncoding());
			response.setHeader("Content-disposition", "attachment;filename=" + fileName);

			IOUtils.copy(fis, response.getOutputStream());
			response.flushBuffer();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 静态文件下载，其实只要把静态文件放在static目录下就能够直接用了(如果文件下载不需要权限，那么这种方式是最好的)
	// tomcat不仅仅是一个servlet容器，他也是一个http服务器呀
	// 比如现在有resource/static/images.zip这个文件
	// 然后只需要发送一个GET请求，url地址为：http://localhost:8768/image.zip就可以下载了


	/**
	 * 上传文件示例
	 * @param labelClass
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@PostMapping("/addLabelClass")
	public Object LabelClassAdd(LabelClass labelClass) throws Exception {
		MultipartFile uploadFile = labelClass.getUploadFile();
		// 规定压缩文件夹名称为image.zip
		String filename = uploadFile.getOriginalFilename();

		// 获取文件上传路径
		String uploadPath = globalProperty.getUploadPath();

		// 1、保存文件到uploadPath路径下的image目录下，即uploadPath/image/image.zip
		String p = uploadPath + "image";
		File f = new File(p);
		if (!f.exists()) {
			f.mkdirs();
		}
		File sourceFile = new File(p,filename);
		uploadFile.transferTo(sourceFile);

		// 2、解压uploadPath/image/image.zip文件，到 uploadPath/picture/时间戳/UUID/image/目录下
		String destFilePath = uploadPath + "picture/" + System.currentTimeMillis() + UUID.randomUUID();
		File destFile = new File(destFilePath);
		if (!destFile.exists()) {
			destFile.mkdirs();
		}
		ZipUtil.deCompress(sourceFile, destFile);

		// 3、获取到uploadPath/picture/时间戳/UUID/image/目录下的所有文件的全路径
		String path = destFilePath + "/" + filename.substring(0,filename.indexOf("."));
		File file = new File(path);
		File[] files = file.listFiles();

		// 4、把图片全路径批量存储到数据库中
		for (int i = 0; i < files.length; i++) {
			logger.info(files[i].getAbsolutePath());
		}

		return "success";
	}


	/**
	 * 获取jar包所在目录示例
	 * @return
	 * @throws FileNotFoundException
	 */
	@ResponseBody
	@GetMapping("/path")
	public Object path() throws FileNotFoundException {

		// 方法一：利用springboot提供的ApplocationHome类得到jar包所在的目录
		String str1 = new ApplicationHome(this.getClass()).getSource().getParentFile().getPath();

		// windows开发环境下，得到的地址为：{项目跟目录}/target
		// 打包成jar放到linux环境下时，得到的地址为：{发布jar包目录}/

		return str1;
	}

	@ResponseBody
	@RequestMapping("/upload")
	public Object upload(MultipartFile uploadFile, String name) throws IOException {

		// 上传文件其实就这么简单
		String str1 = new ApplicationHome(this.getClass()).getSource().getParentFile().getPath();
		File file = new File(str1 + "/uploadFile",uploadFile.getOriginalFilename());
		if (!file.exists()) {
			file.mkdirs();
		}
		uploadFile.transferTo(file);

		return file.getAbsolutePath();
	}

	/**
	 * 测试classpath路径在开发和部署时的区别
	 * @return
	 * @throws FileNotFoundException
	 */
	@ResponseBody
	@GetMapping("/classpath")
	public Object classpath() throws FileNotFoundException {

		// 记住这一个API就可以了哦
		String str3 = ResourceUtils.getURL("classpath:").getPath();

		// classpath就是指的 classes 这个目录所在的路径哦

		// windows下这前面有一个"/"，不知道为哈，格式是这样的,而且是在target目录下，而不是jar下面：
		// /D:/KEQI/code/keqi-code-demo-study/springboot-upload-download/target/classes/


		// linux 系统下就是在那个打包好的jar包下面了哦,这里还有莫名其妙的感叹号，
		/*
		file:/home/keqi/myApp/springboot-upload-download/
		springboot-upload-download-8769/springboot-upload-download-0.0.1-SNAPSHOT.jar!/BOOT-INF/classes!/
		*/

		// 总结: 不要试图通过classpath来找到jar包所处路径，这是不科学的，springboot提供了一个ApplicationHome类
		// 能够直接找到jar包所在路径，非常的方便,在通过getParent()方法就可以很方便的找到jar包同级目录啦，哈哈

		return str3;
	}

	// 也彻底理解文件上传这个，同时要立即文件IO、网络文件传输，HTTP断点续传什么的哦

}
