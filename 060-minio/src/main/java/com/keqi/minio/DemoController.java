package com.keqi.minio;

import io.minio.MinioClient;
import io.minio.PostPolicy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
public class DemoController {


    /*
        1、下载文件：客户端请求应用服务器要下载指定文件，应用服务器使用 presignedGetObject 向 minio 服务发送命令，得到一个
        下载链接，客户端通过此链接就可以实现下载文件了

        2、删除文件：客户端请求应用服务器要删除指定文件，应用服务器使用 removeObject 向 minio 服务发送命令，直接删除文件

        3、上传文件：客户端请求应用服务器要上传指定文件，应用服务器使用presignedPutObject向 minio服务发送命令，
         返回对应的信息（一个带了很多参数的 url），客户端使用此url发送put请求，并在body中带上文件的二进制方式

     */


    @GetMapping("download")
    public String download(String objectName) throws Throwable {
        // 客户端传递一个对象名称，对象的全程为 /桶名称/文件夹名称/文件名称（不能带上桶的名称）
        // 正确示例如：/a/Postman-win64-8.10.0-Setup.exe（最前面的 / 可以带也可以不带）
        MinioClient minioClient =
                new MinioClient("http://192.168.74.132:9000", "minioadmin", "minioadmin");
        String s = minioClient.presignedGetObject("tese1", objectName);
        return s;
    }

    @GetMapping("upload")
    public String upload(String objectName) throws Throwable {
        MinioClient minioClient =
                new MinioClient("http://192.168.74.132:9000", "minioadmin", "minioadmin");
        PostPolicy postPolicy = new PostPolicy("tese1", objectName, ZonedDateTime.now().plusDays(1));

        // 返回值是一个 url(带上了很多参数的) ，直接向此 url 发送请求(PUT)，并且 body 里面带上二进制文件就行（）

        /*
            js 使用示例

            var data = "<file contents here>";

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function() {
  if(this.readyState === 4) {
    console.log(this.responseText);
  }
});

xhr.open("PUT", "http://192.168.74.132:9000/tese1/fms-4.8.3.exe?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%252F20210826%252Fus-east-1%252Fs3%252Faws4_request&X-Amz-Date=20210826T105014Z&X-Amz-Expires=604800&X-Amz-SignedHeaders=host&X-Amz-Signature=cc3489d0350cee8e0ce3af5c10395d232d98d119a33d2ec711bb83bfcbfbe4d1");
xhr.setRequestHeader("Content-Type", "application/x-msdos-program");

xhr.send(data);


         */



        return minioClient.presignedPutObject("tese1", objectName);





        /*Map<String, String> stringStringMap = minioClient.presignedPostPolicy(postPolicy);
        for (Map.Entry<String, String> entry : stringStringMap.entrySet()) {
            // 使用 curl 命令带上这些参数，就可以进行文件上传

            // 对于客户端调用，具体应该如何进行传参呢？？？当然是 multipart/form-data 啦 方式进行上传啦，把这几个参数都给带上就行
            // 使用 postman 进行测试后，发现是正确的 todo 未找到解决办法哦，这个必须要知道如何解决
            // 上传文件的那个字段叫做 file （https://juejin.cn/post/6978304433809522719）
            System.out.print(" -F " + entry.getKey() + "=" + entry.getValue());
        }*/
        // 换成 put 请求（还是没有成功）
        // String url = minioClient.presignedPutObject("tese1", objectName, 60 * 60 * 24);

        // 直接上传本地文件(这种方法肯定是没有问题的)
       /* String name = UUID.randomUUID().toString() + ".txt";
        minioClient.putObject("tese1", name, "C:\\Users\\keqi\\Desktop\\本周.txt", null);*/

        /*return stringStringMap;*/
    }

    @GetMapping("delete")
    public String delete(String objectName) throws Throwable {
        MinioClient minioClient =
                new MinioClient("http://192.168.74.132:9000", "minioadmin", "minioadmin");
        minioClient.removeObject("tese1", objectName);
        return "success";
    }

    @GetMapping("upload2")
    public String upload2(String objectName) throws Throwable {
        MinioClient minioClient =
                new MinioClient("http://192.168.74.132:9000", "minioadmin", "minioadmin");


        return "success";
    }
}
