package com.keqi.springbootstaticresource01.config;

import com.keqi.springbootstaticresource01.util.CommonUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

	/**
	 * 添加静态资源映射路径
	 * @param registry registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		/*
		SpringBoot MVC 默认情况下已经自动配置了几个静态资源映射路径，在 org.springframework.boot.autoconfigure.web.ResourceProperties
		类的CLASSPATH_RESOURCE_LOCATIONS属性已经指定了，具体可以参见源码。

		但是有时候，会需要在这个基础上自定义一些静态映射关系，就可以通过重写addResourceHandlers()方法来实现
		 */

		// 这里将 /mystatic/** 路径下的静态资源请求直接映射到 classpath:/mystatic/ 目录下，也就是到这个目录下去找同名文件并下载
		// 此处新增的映射关系不会影响到默认配置好的映射
		// 在浏览器通过url：http://localhost:8080/mystatic/b.png 就能够访问到这个目录下存放的文件了
		registry.addResourceHandler("/mystatic/**").addResourceLocations("classpath:/mystatic/");

		// 客户端上传的文件直接通过ApplicationHome类动态的获取路径，并存储在和jar包同一个目录下（即使用本地文件系统存储）
		// 那么可以利用这种方式做静态资源路径的映射。前缀可以定为 /file/** ，这个随意啦
		// 如果映射路径是本地文件系统，那就需要加上"file:"前缀
		// 经过测试，完美通过，这样使用本地文件系统存储文件，并灵活配置静态资源映射，直接使用tomcat作为静态资源服务器是很优雅的方式
		String filePath = "file:" + CommonUtil.getApplicationHomeAbsolutePath() + "/uploadFile/";
		registry.addResourceHandler("/file/**").addResourceLocations(filePath);
	}
}
