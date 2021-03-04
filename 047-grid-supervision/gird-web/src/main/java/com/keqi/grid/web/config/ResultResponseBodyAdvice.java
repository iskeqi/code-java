package com.keqi.grid.web.config;

import com.keqi.grid.core.response.ResultEntity;
import com.keqi.grid.core.response.ResultEntityBuilder;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Type;

/**
 * 针对 @ResponseBody 注解响应的接口做统一处理
 *
 * @author keqi
 */
@ControllerAdvice(basePackages = "com.keqi.gird")
public class ResultResponseBodyAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
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
