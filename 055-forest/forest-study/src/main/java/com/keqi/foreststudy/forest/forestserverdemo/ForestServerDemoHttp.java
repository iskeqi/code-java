package com.keqi.foreststudy.forest.forestserverdemo;

import com.dtflys.forest.annotation.*;
import com.dtflys.forest.http.ForestResponse;

@BaseRequest(
        baseURL = "http://localhost:9090",
        timeout = 5000,
        interceptor = ForestServerDemoHttpInterceptor.class)
public interface ForestServerDemoHttp {

    @Get("/test1")
    ForestResponse<ResultEntity<Test1Dto>> test1(@Query("username") String username, @Query("password")String password);

    @Post("/test2")
    ForestResponse<ResultEntity<Test1Dto>> test2(@JSONBody Test1Dto test1Dto);

    /*
        forest 与其他 HTTP 类库相比较，优点是使用方便、文档齐全，学习成本低
     */
}
