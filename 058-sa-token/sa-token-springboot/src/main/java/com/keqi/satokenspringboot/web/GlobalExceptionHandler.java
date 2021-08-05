package com.keqi.satokenspringboot.web;

import cn.dev33.satoken.exception.*;
import com.keqi.satokenspringboot.core.response.ResultEntity;
import com.keqi.satokenspringboot.core.response.ResultEntityBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器
 * <p>
 * (SpringMVC 中此类可以存在多个，可根据实际情况进行扩展，但是如果这个类中捕获了 Throwable.class 后，
 * 其它子异常就不会生效，这个问题应该如何结局呢？)
 *
 * @author keqi
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @Value("${spring.profiles.active:local-dev}")
    private String active;

    /**
     * SaTokenException
     *
     * @param e SaTokenException
     * @return r
     */
    @ExceptionHandler(value = SaTokenException.class)
    public ResultEntity businessException(SaTokenException e) {
        if (e instanceof DisableLoginException) {
            return ResultEntityBuilder.noAuth("当前账号被禁用");
        }
        if (e instanceof IdTokenInvalidException) {
            // 当前 token 无效
            return ResultEntityBuilder.noAuth("当前账号未登录");
        }
        if (e instanceof NotLoginException) {
            return ResultEntityBuilder.noAuth("当前账号未登录");
        }
        if (e instanceof NotPermissionException) {
            return ResultEntityBuilder.noAuth("当前账号无此操作权限");
        }
        if (e instanceof NotRoleException) {
            return ResultEntityBuilder.noAuth("当前账号无此操作权限");
        }
        if (e instanceof NotSafeException) {
            return ResultEntityBuilder.noAuth("当前操作未通过二级认证");
        }
        return ResultEntityBuilder.noAuth(e.getMessage());
    }


}
