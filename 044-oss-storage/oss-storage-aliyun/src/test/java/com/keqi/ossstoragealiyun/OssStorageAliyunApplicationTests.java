package com.keqi.ossstoragealiyun;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.PutObjectResult;
import com.keqi.ossstoragealiyun.util.OSSUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class OssStorageAliyunApplicationTests {

    @Autowired
    OSSUtil ossUtil;

    @Test
    void contextLoads() throws FileNotFoundException {
        String signedUrl = ossUtil.getUploadUrl("a");

        // 使用签名URL发送请求。
        File f = new File("E:\\KEQI\\资料\\a.pdf");
        FileInputStream fin = new FileInputStream(f);
        Map<String, String> customHeaders = new HashMap<String, String>();
        customHeaders.put("Content-Type", "application/octet-stream");
        // customHeaders.put("x-oss-meta-author", "aliy");

        OSS ossClient = ossUtil.getOssClient();
        // ossClient.putObject(signedUrl, fin, f.length(), customHeaders);
    }

}
