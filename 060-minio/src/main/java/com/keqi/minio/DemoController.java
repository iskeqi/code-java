package com.keqi.minio;

import io.minio.MinioClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        // 客户端传递一个对象名称，对象的全程为 /桶名称/文件夹名称/文件名称
        // 后端手动去除掉第一个 “/桶名称/”
        // 然后作为参数调用 minio 服务
        /*int i = objectName.indexOf("/", 1);
        objectName = objectName.substring(i + 1);

        MinioClient minioClient =
                new MinioClient("http://192.168.74.132:9000", "minioadmin", "minioadmin");
        String s = minioClient.presignedGetObject("tese1", objectName);
        return s;*/
        return MinioUtil.download(objectName);
    }

    @GetMapping("upload")
    public String upload(String objectName) throws Throwable {

        // 要求前端上传文件的真实文件名称.后缀的参数到此接口
        // 后端在文件的前面拼接上当天的日期（如：2021-08-27）以及simple UUID字符串，此时 objectName 为：/bucketName/2021-08-27/UUID-真实文件名称
        // 后端检查此文件是否存在，或者不检查（日期、UUID都是后端控制的，确实没有必要再继续判断文件是否存在了）
        // 返回文件上传 url 和当前文件名称(存储桶策略必须指定为不可覆盖同名文件)
        // 前端根据返回的url 发送 put 请求，并在请求体里面带上文件内容，即可实现文件的直传

        /*objectName = LocalDate.now() + "/" + UUID.randomUUID().toString().replaceAll("-", "") + "-" + objectName;

        MinioClient minioClient =
                new MinioClient("http://192.168.74.132:9000", "minioadmin", "minioadmin");
        PostPolicy postPolicy = new PostPolicy("tese1", objectName, ZonedDateTime.now().plusDays(1));*/

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


        /*return minioClient.presignedPutObject("tese1", objectName);*/
        return MinioUtil.upload(objectName);




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
        /*int i = objectName.indexOf("/", 1);
        objectName = objectName.substring(i + 1);

        MinioClient minioClient =
                new MinioClient("http://192.168.74.132:9000", "minioadmin", "minioadmin");
        minioClient.removeObject("tese1", objectName);
        return "success";*/
        MinioUtil.delete(objectName);
        return "success";
    }

    @GetMapping("upload2")
    public String upload2(String objectName) throws Throwable {
        MinioClient minioClient =
                new MinioClient("http://192.168.74.132:9000", "minioadmin", "minioadmin");


        return "success";
    }
}
