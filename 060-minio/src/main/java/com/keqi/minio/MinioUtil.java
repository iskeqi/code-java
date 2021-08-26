package com.keqi.minio;

import io.minio.MinioClient;
import io.minio.errors.InvalidEndpointException;
import io.minio.errors.InvalidPortException;

public class MinioUtil {

    public static MinioClient minioClient;

    static {
        try {
            minioClient = new MinioClient("http://192.168.74.132:9000", "minioadmin", "minioadmin");
        } catch (InvalidEndpointException | InvalidPortException e) {
            e.printStackTrace();
        }
    }


}
