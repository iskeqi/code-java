package com.keqi.apihu.core.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Type;

/**
 * 针对 @ResponseBody 注解响应的接口做统一处理
 * 实现原理：
 * 1、controller 的方法中响应了返回值后，正常的执行逻辑是：HttpMessageConverter 会序列化成 JSON，然后返回给客户端
 * 2、如果实现了 ResponseBodyAdvice 接口，此接口中允许在 HttpMessageConverter 序列化之前，替换掉 Controller 中接口返回值
 *
 * @author keqi
 */
@ControllerAdvice(basePackages = "com.keqi.knife4j")
public class ResultResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 获取 Controler 中方法的返回值类型对应的 Class 反射对象
        Type type = methodParameter.getGenericParameterType();

        if (String.class == type || ResultEntity.class == type) {
            return o;
        } else if (void.class == type) {
            return ResultEntityBuilder.success();
        } else {
            return ResultEntityBuilder.success(o);
        }
    }
}
