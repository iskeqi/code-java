package com.keqi.ossstoragealiyun.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {

    /*
     * OSS 存储最佳使用方式是由客户端直接上传文件到 OSS 服务器，但是每次执行上传和下载操作的时候，需要先向应用服务器获取临时访问签名
     *
     *
     * 1、开通OSS服务、开通访问账号权限、在控制台手动新建一个 bucket
     * 2、后台提供上传文件签名接口，下载文件签名接口
     * 3、文件对象名称有客户端通过 uuid+文件名称 组成
     * 3、每次调用接口的参数有：文件名称、accessToken
     * 4、后台在业务上只需要存储文件对象的名称即可
     *
     */
}
