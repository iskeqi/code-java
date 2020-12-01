package com.keqi.springbootmvcparam.advice;

import com.keqi.springbootmvcparam.common.AjaxEntityBuilder;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Type;

/**
 * 此接口的作用是：拦截指定包下controller的ResponseBody的返回值，在ResponseBody返回值之前执行一定操作
 * 能够利用它来作为统一的返回值： 拦截Controller方法默认返回参数，统一处理返回值/响应体
 *
 * 本质上就是：controller的方法中响应了返回值后，正常的执行逻辑是：HttpMessageConverter 会序列化成 JSON，然后返回给客户端
 * 但是如果项目中实现了 ResponseBodyAdvice 接口，那么就能在 HttpMessageConverter 转换 controller 方法返回值之前，实现
 * 狸猫换太子的功能，替换掉之前的对象，返回一个新的对象给客户端（不信？？？可以在此做一个测试）
 */
@ControllerAdvice(basePackages = "com.keqi")
public class ApiResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        System.out.println("supports");
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        Type type = methodParameter.getGenericParameterType();

        if (String.class == type) {
            System.out.println("String.class");
            return o;
        }
        if (void.class == type) {
            System.out.println("void.class");
            return AjaxEntityBuilder.success();
        }

        return AjaxEntityBuilder.success(o);
        // return "dfa"; // 如果这么写，无论哪个接口，就都会返回 dsf
    }
}
