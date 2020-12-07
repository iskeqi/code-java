package com.keqi.knife4j.core.util;

import cn.hutool.crypto.SecureUtil;
import org.springframework.boot.system.ApplicationHome;

/**
 * 公共工具类（不知道怎么分类就放在这里）
 *
 * @author keqi
 */
public class CommonUtil {

    private static final String secret = "12O!dZ@%YXsvOaKHC";

    /**
     * 动态获取到 jar 包所在的绝对目录
     * <p>
     * 比如：app.jar 文件的绝对路径是： /home/course/iot/app.jar，那么这里返回的就是：/home/course/iot
     * 没有斜杠作为后缀
     * <p>
     * windows 启动时，路径是 D:\KEQI\code\code-java\029-springboot-static-resource
     *
     * @return r
     */
    public static String getApplicationHomeAbsolutePath() {
        ApplicationHome applicationHome = new ApplicationHome();
        return applicationHome.getDir().getAbsolutePath();
    }

    /**
     * 加密密码(登录时，也需要时候用此逻辑)
     *
     * @return r
     */
    public static String encryptedPassword(String username, String password) {
        return SecureUtil.sha256(SecureUtil.md5(username + secret + password));
    }

    public static void main(String[] args) {
        System.out.println(encryptedPassword("admin", "123456"));
    }
}
