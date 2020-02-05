package com.keqi.springbootupload.config;

/**
 * @author keqi
 */

import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	/**
	 * 资源映射配置
	 *
	 * @param registry
	 */
	/*@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		String str1 = new ApplicationHome(this.getClass()).getSource().getParentFile().getPath();
		System.out.println(str1);

		registry.addResourceHandler("/files/**")
				.addResourceLocations("file:" + str1 + "/uploadFile");



		super.addResourceHandlers(registry);
	}*/

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		// 这样就能够固定把文件挂载在jar包同级的目录下了(一定要牢牢掌握ApplicationHome这个类哦)
		// 而且还可以把这个目录直接对外公开
		String str1 = new ApplicationHome(this.getClass()).getSource().getParentFile().getPath();
		String s = "file:" +  str1 + "/uploadFile/";
		System.out.println(s);
		registry.addResourceHandler("/img/**").addResourceLocations(s);

		registry.addResourceHandler("/**")
				.addResourceLocations("classpath:/META-INF/resources/")
				.addResourceLocations("classpath:/resources/")
				.addResourceLocations("classpath:/static/")
				.addResourceLocations("classpath:/public/");

	}
}
