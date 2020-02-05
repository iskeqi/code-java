package com.keqi.springbootupload.config;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 全局属性配置类(这种在程序中根据操作系统动态决定文件存储路径的方式还是有一定意义的)
 * @author keqi
 */
@Component
public class GlobalProperty {

	private final Environment environment;

	public GlobalProperty(Environment environment) {
		this.environment = environment;
	}

	/**
	 * 根据当前程序运行所处的不同环境来决定使用哪个存储路径
	 * @return uploadPath路径
	 */
	// 掌握了ApplicationHome类的用法之后，就不需要用这种自己想出来的东西啦
	public String getUploadPath() {
		String linux = environment.getProperty("grace.linux.upload.path");
		String windows = environment.getProperty("grace.windows.upload.path");
		String macos = environment.getProperty("grace.macos.upload.path");
		String osName = System.getProperty("os.name");
		if (osName.startsWith("Windows")) {
			return windows;
		} else if (osName.startsWith("Mac OS")) {
			return macos;
		}
		return linux;
	}

	/**
	 * 获取配置文件的属性值
	 * @param key key
	 * @return value
	 */
	public String getProperty(String key) {
		return environment.getProperty(key);
	}
}
