package com.keqi.foreststudy.forest.interceptor;

import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.dtflys.forest.reflection.ForestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Component
public class SimpleInterceptor implements Interceptor<String> {

    private final static Logger log = LoggerFactory.getLogger(SimpleInterceptor.class);

    /**
     * 该方法在被调用时，并在beforeExecute前被调用
     * @Param request Forest请求对象
     * @Param args 方法被调用时传入的参数数组
     */
    @Override
    public void onInvokeMethod(ForestRequest request, ForestMethod method, Object[] args) {
        log.info("on invoke method");

        // addAttribute作用是添加和Request以及该拦截器绑定的属性
        addAttribute(request, "A", "value1");
        addAttribute(request, "B", "value2");
    }

    /**
     * 该方法在请求发送之前被调用, 若返回false则不会继续发送请求
     * @Param request Forest请求对象
     */
    @Override
    public boolean beforeExecute(ForestRequest request) {
        log.info("invoke Simple beforeExecute");
        // 执行在发送请求之前处理的代码
        request.addHeader("accessToken", "11111111");  // 添加Header
        request.addQuery("username", "foo");  // 添加URL的Query参数
        return true;  // 继续执行请求返回true
    }

    /**
     * 该方法在请求成功响应时被调用
     */
    @Override
    public void onSuccess(String data, ForestRequest request, ForestResponse response) {
        log.info("invoke Simple onSuccess");
        // 执行成功接收响应后处理的代码
        int status = response.getStatusCode(); // 获取请求响应状态码
        String content = response.getContent(); // 获取请求的响应内容
        String result = data;  // data参数是方法返回类型对应的返回数据结果
        result = (String) response.getResult(); // getResult()也可以获取返回的数据结果
        response.setResult("修改后的结果: " + result);  // 可以修改请求响应的返回数据结果

        // 使用getAttributeAsString取出属性，这里只能取到与该Request对象，以及该拦截器绑定的属性
        String attrValue1 = getAttributeAsString(request, "A1");

    }

    /**
     * 该方法在请求发送失败时被调用
     */
    @Override
    public void onError(ForestRuntimeException ex, ForestRequest request, ForestResponse response) {
        log.info("invoke Simple onError");
        // 执行发送请求失败后处理的代码
        int status = response.getStatusCode(); // 获取请求响应状态码
        String content = response.getContent(); // 获取请求的响应内容
        String result = (String) response.getResult(); // 获取方法返回类型对应的返回数据结果
    }

    /**
     * 该方法在请求发送之后被调用
     */
    @Override
    public void afterExecute(ForestRequest request, ForestResponse response) {
        // 这个接口在 onSuccess 之后，onError 之后
        log.info("invoke Simple afterExecute");
        // 执行在发送请求之后处理的代码
        int status = response.getStatusCode(); // 获取请求响应状态码
        String content = response.getContent(); // 获取请求的响应内容
        String result = (String) response.getResult(); // 获取方法返回类型对应的最终数据结果


        /*
        无论HTTP请求是成功还是失败，都会执行此方法，通常都会有以下2种情况需要处理
            HTTP请求失败
            HTTP请求成功，但是业务上失败了（这也是一种失败场景）

            // response.setException(new RuntimeException());
            // 通过这种方式将 response.isSuccess() 的返回结果设置为 false
            // 调用方就可以根据实际业务场景决定请求失败时，该如何去处理了
         */
    }
}

