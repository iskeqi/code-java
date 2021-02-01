package com.keqi.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ApplicationContext appCtx;

    @Autowired
    private StringEncryptor codeSheepEncryptorBean;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        Environment environment = appCtx.getBean(Environment.class);

        // 首先获取配置文件里的原始明文信息
        String mysqlOriginPswd = environment.getProperty("spring.datasource.password");
        String redisOriginPswd = environment.getProperty("redis.password");
        String aliSmsOriginAk = environment.getProperty("ali.sms.access_key_secret");

        // 加密
        String mysqlEncryptedPswd = encrypt(mysqlOriginPswd);
        String redisEncryptedPswd = encrypt(redisOriginPswd);
        String aliSmsEncryptedAk = encrypt(aliSmsOriginAk);

        // 打印加密前后的结果对比
        System.out.println("MySQL原始明文密码为：" + mysqlOriginPswd);
        System.out.println("Redis原始明文密码为：" + redisOriginPswd);
        System.out.println("阿里云SMS原始AccessKey密码为：" + aliSmsOriginAk);
        System.out.println("====================================");
        System.out.println("MySQL原始明文密码加密后的结果为：" + mysqlEncryptedPswd);
        System.out.println("Redis原始明文密码加密后的结果为：" + redisEncryptedPswd);
        System.out.println("阿里云SMS原始AccessKey密码加密后的结果为：" + aliSmsEncryptedAk);
    }

    private String encrypt(String originPassord) {
        String encryptStr = codeSheepEncryptorBean.encrypt(originPassord);
        return encryptStr;
    }

    private String decrypt(String encryptedPassword) {
        String decryptStr = codeSheepEncryptorBean.decrypt(encryptedPassword);
        return decryptStr;
    }
}
