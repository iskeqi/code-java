package com.keqi.foreststudy.forest.service;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.callback.OnError;
import com.dtflys.forest.callback.OnSuccess;

/**
 * @BaseRequest 为配置接口层级请求信息的注解，
 * 其属性会成为该接口下所有请求的默认属性，
 * 但可以被方法上定义的属性所覆盖
 */
@BaseRequest(
        baseURL = "http://localhost:8080",     // 默认域名
        headers = {
                "Accept:text/plain"                // 默认请求头
        },
        sslProtocol = "TLS"                    // 默认单向SSL协议
)
public interface MyClient2 {

    // 调用同一个第三方服务时，很多配置都是相同的，可以使用@BaseRequest注解统一指定的信息

    // 方法的URL不必再写域名部分
    @Get("/hello/user")
    String send1(@Query("username") String username);

    // 若方法的URL是完整包含http://开头的，那么会以方法的URL中域名为准，不会被接口层级中的baseURL属性覆盖
    @Get("http://www.xxx.com/hello/user")
    String send2(@Query("username") String username);


    @Get(
            url = "/hello/user",
            headers = {
                    "Accept:application/json"      // 覆盖接口层级配置的请求头信息
            },
            dataType = ""
    )
    String send3(@Query("username") String username, OnSuccess<String> onSuccess, OnError onError);

    // HTTP 调用必须要考虑失败场景，成功场景人人都会，也不会有什么问题

    /**
     * 省略dataType属性会自动判断返回的数据格式并进行反序列化
     */
    //@Get("http://localhost:8080/user?id=${0}")
    //User getUser(Integer id)
    // 可以自动的进行反序列化，无需手动指定 dataType 属性
}
