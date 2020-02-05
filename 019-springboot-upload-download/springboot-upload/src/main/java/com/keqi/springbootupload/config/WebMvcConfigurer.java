package com.keqi.springbootupload.config;/*
package com.keqi.springbootuploaddownload.config;

import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	//访问静态资源
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String str1 = new ApplicationHome(this.getClass()).getSource().getParentFile().getPath();
		//registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		//SAVEPATH就是上面的basePath，当请求Url包含static/files/时，就会以文件路径来访问basePath下面的文件
		registry.addResourceHandler("/files/**").addResourceLocations("file:" + str1 + "/uploadFile");
		super.addResourceHandlers(registry);

	}
	通过代码的方式配置静态资源映射目录，没有成功，不知道怎么设置
 */
/*}*/
