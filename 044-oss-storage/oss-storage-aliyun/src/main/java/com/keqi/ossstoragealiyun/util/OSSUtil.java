package com.keqi.ossstoragealiyun.util;

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.utils.DateUtil;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.URL;
import java.util.Date;

/**
 * OSS util 工具类
 */
@Component
public class OSSUtil {

    private static final String endpoint = "oss-cn-shenzhen.aliyuncs.com";
    private static final String accessKeyId = "LTAI4GC7EyvU5XqUziFvkCdS";
    private static final String accessKeySecret = "jXA6zOcudCSWeampantzSEz0syilpN";
    private static final String bucketName = "oss-study-keqi";

    private OSS ossClient;

    @PostConstruct
    public void init() {
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }


    public OSS getOssClient() {
        return this.ossClient;
    }

    /**
     * 上传文件
     *
     * @param objectName  objectName
     * @param inputStream inputStream
     */
    public boolean putObject(String objectName, InputStream inputStream) {
        PutObjectResult putObjectResult = this.ossClient.putObject(bucketName, objectName, inputStream);
        int statusCode = putObjectResult.getResponse().getStatusCode();
        return 200 == statusCode;
    }

    public void getObject(String objectName) {
        OSSObject ossObject = ossClient.getObject(bucketName, objectName);

        InputStream objectContent = ossObject.getObjectContent();
        try {
            objectContent.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteObject(String objectName) {
        ossClient.deleteObject(bucketName, objectName);
    }

    /**
     * 返回指定 objectName 对象的上传文件签名
     *
     * @param objectName objectName
     * @return
     */
    public String getUploadUrl(String objectName) {
        Date expiration = new Date(System.currentTimeMillis() + 3600000);
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, objectName, HttpMethod.PUT);
        request.setExpiration(expiration);
        request.setContentType("application/octet-stream");
        // request.addUserMetadata("author", "aliy");

        URL signedUrl = ossClient.generatePresignedUrl(request);

        return signedUrl.toString();
    }

    /**
     * 返回指定 objectName 对象的下载文件签名
     *
     * @param objectName objectName
     * @return
     */
    public String getDownloadUrl(String objectName) {

        Date expiration = new Date(System.currentTimeMillis() + 3600000);
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucketName, objectName, HttpMethod.GET);
        request.setExpiration(expiration);
        // request.addUserMetadata("author", "aliy");
        URL signedUrl = ossClient .generatePresignedUrl(request);

        return signedUrl.toString();
    }


}





















