package com.keqi.springbootstaticresource01.util;

import org.springframework.boot.system.ApplicationHome;

/**
 * 公共工具类（不知道怎么分类就放在这里）
 */
public class CommonUtil {


	/**
	 * 动态获取到 jar 包所在的绝对目录
	 *
	 * 比如：app.jar 文件的绝对路径是： /home/course/iot/app.jar，那么这里返回的就是：/home/course/iot
	 * 没有斜杠作为后缀
	 *
	 * windows 启动时，路径是 D:\KEQI\code\code-java\029-springboot-static-resource
	 * @return r
	 */
	public static String getApplicationHomeAbsolutePath() {
		ApplicationHome applicationHome = new ApplicationHome();
		return applicationHome.getDir().getAbsolutePath();
	}

}
