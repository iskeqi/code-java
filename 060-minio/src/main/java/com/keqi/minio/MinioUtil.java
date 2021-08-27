package com.keqi.minio;

import io.minio.MinioClient;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@Component
public class MinioUtil {

    @SneakyThrows
    public static String upload(String objectName) {
        objectName = LocalDate.now() + "/" + UUID.randomUUID().toString().replaceAll("-", "") + "-" + objectName;
        return minioClient.presignedPutObject(defaultBucket, objectName);
    }

    @SneakyThrows
    public static String upload(String bucketName, String objectName) {
        objectName = LocalDate.now() + "/" + UUID.randomUUID().toString().replaceAll("-", "") + "-" + objectName;
        return minioClient.presignedPutObject(bucketName, objectName);
    }

    @SneakyThrows
    public static void delete(String objectName) {
        objectName = objectName.substring(objectName.indexOf("/", 1) + 1);
        minioClient.removeObject(defaultBucket, objectName);
    }

    @SneakyThrows
    public static void delete(String bucketName, String objectName) {
        objectName = objectName.substring(objectName.indexOf("/", 1) + 1);
        minioClient.removeObject(bucketName, objectName);
    }

    @SneakyThrows
    public static String download(String objectName) {
        objectName = objectName.substring(objectName.indexOf("/", 1) + 1);
        return minioClient.presignedGetObject(defaultBucket, objectName);
    }

    @SneakyThrows
    public static String download(String bucketName, String objectName) {
        objectName = objectName.substring(objectName.indexOf("/", 1) + 1);
        return minioClient.presignedGetObject(bucketName, objectName);
    }

    @SneakyThrows
    public static void makeBucket(String bucketName) {
        minioClient.makeBucket(bucketName);
    }

    @PostConstruct
    public void init() throws Exception {
        minioClient = new MinioClient(endpoint, accessKey, secretKey);

        // 判断默认桶是否存在，不存在则创建桶
        if (!minioClient.bucketExists(defaultBucket)) {
            minioClient.makeBucket(defaultBucket);
        }
    }

    private static String endpoint;

    private static String accessKey;

    private static String secretKey;

    private static String defaultBucket;

    private static MinioClient minioClient;

    @Value("${minio.endpoint}")
    public void setEndpoint(String endpoint) {
        MinioUtil.endpoint = endpoint;
    }

    @Value("${minio.accessKey}")
    public void setAccessKey(String accessKey) {
        MinioUtil.accessKey = accessKey;
    }

    @Value("${minio.secretKey}")
    public void setSecretKey(String secretKey) {
        MinioUtil.secretKey = secretKey;
    }

    @Value("${minio.defaultBucket}")
    public void setDefaultBucket(String defaultBucket) {
        MinioUtil.defaultBucket = defaultBucket;
    }
}
