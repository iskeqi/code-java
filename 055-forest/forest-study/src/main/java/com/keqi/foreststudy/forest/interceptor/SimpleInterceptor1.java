package com.keqi.foreststudy.forest.interceptor;

import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;

public class SimpleInterceptor1 implements Interceptor<String> {

    /*
        forest 中的拦截器非常重要


     */



    /**
     * 该方法在请求发送之后被调用
     */
    @Override
    public void afterExecute(ForestRequest request, ForestResponse response) {
        // 执行在发送请求之后处理的代码
        int status = response.getStatusCode(); // 获取请求响应状态码
        String content = response.getContent(); // 获取请求的响应内容
        String result = (String) response.getResult(); // 获取方法返回类型对应的最终数据结果
        // 响应之后的拦截器
    }

    @Override
    public void onSuccess(String data, ForestRequest request, ForestResponse response) {
        // HTTP 请求成功后，再从业务上判断下是否成功
        Interceptor.super.onSuccess(data, request, response);
    }
}
