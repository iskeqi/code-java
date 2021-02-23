package com.keqi.ossstoragealiyun;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.DateUtil;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.keqi.ossstoragealiyun.util.OSSUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class OssStorageAliyunApplicationTests {

    @Autowired
    OSSUtil ossUtil;

    @Test
    void contextLoads() throws FileNotFoundException {
        URL signedUrl = ossUtil.getUploadUrl("a.pdf");

        // 使用签名URL发送请求。
        File f = new File("E:\\KEQI\\资料\\a.pdf");
        FileInputStream fin = new FileInputStream(f);
        Map<String, String> customHeaders = new HashMap<String, String>();
        customHeaders.put("Content-Type", "application/octet-stream");
        // customHeaders.put("x-oss-meta-author", "aliy");

        OSS ossClient = ossUtil.getOssClient();
        ossClient.putObject(signedUrl, fin, f.length(), customHeaders);
    }

    @Test
    void test() throws FileNotFoundException {
        String endpoint = "oss-cn-shenzhen.aliyuncs.com";
        String accessKeyId = "LTAI4GC7EyvU5XqUziFvkCdS";
        String accessKeySecret = "jXA6zOcudCSWeampantzSEz0syilpN";
        String bucketName = "oss-study-keqi";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 生成签名URL。
        Date expiration = new Date(System.currentTimeMillis() + 3600000);
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, "a.pdf", HttpMethod.PUT);
        // 设置过期时间。
        request.setExpiration(expiration);
        // 设置ContentType。
        request.setContentType("application/octet-stream");
        // 通过HTTP PUT请求生成签名URL。
        URL signedUrl = ossClient.generatePresignedUrl(request);
        System.out.println("signed url for putObject: " + signedUrl);

        // 使用签名URL发送请求。
        File f = new File("E:\\KEQI\\资料\\a.pdf");
        FileInputStream fin = new FileInputStream(f);
        // 添加PutObject请求头。
        Map<String, String> customHeaders = new HashMap<String, String>();
        customHeaders.put("Content-Type", "application/octet-stream");

        PutObjectResult result = ossClient.putObject(signedUrl, fin, f.length(), customHeaders);

        // 关闭OSSClient。
        ossClient.shutdown();

    }
}
