package com.keqi.bestpracticeone.core.exception;

import com.keqi.bestpracticeone.core.response.ResultEntity;
import com.keqi.bestpracticeone.core.response.ResultEntityBuilder;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * 全局异常处理器
 *
 * @author keqi
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 专治表单以及GET方式提交参数进行校验时的异常
     */
    @ExceptionHandler(value = BindException.class)
    public ResultEntity errorHandler(BindException e) {
        e.printStackTrace();
        // 有多个异常时直接凭借出来一次性给出
        StringBuilder errorMsg = new StringBuilder();
        for (ObjectError allError : e.getBindingResult().getAllErrors()) {
            errorMsg.append(allError.getDefaultMessage()).append(",");
        }
        errorMsg.delete(errorMsg.length() - 1, errorMsg.length());

        return ResultEntityBuilder.failure(errorMsg.toString());
    }

    /**
     * 专治请求体为JSON时提交参数进行校验时的异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        e.printStackTrace();
        StringBuilder errorMsg = new StringBuilder();
        for (ObjectError allError : e.getBindingResult().getAllErrors()) {
            errorMsg.append(allError.getDefaultMessage()).append(",");
        }
        errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
        return ResultEntityBuilder.failure(errorMsg.toString());
    }

    /**
     * ValidationException
     */
    @ExceptionHandler({ValidationException.class})
    public ResultEntity handleValidationException(ValidationException e) {
        e.printStackTrace();
        return ResultEntityBuilder.failure(e.getCause().getMessage());
    }

    /**
     * ConstraintViolationException
     * 使用@Validated注解验证方法参数中的@RequestParam注解和@PathVariable注解对应的值，抛出的是这种异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultEntity handleConstraintViolationException(ConstraintViolationException e) {
        e.printStackTrace();
        StringBuilder errorMsg = new StringBuilder();
        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
            errorMsg.append(constraintViolation.getMessage()).append(",");
        }
        errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
        return ResultEntityBuilder.failure(errorMsg.toString());
    }

    /**
     * 自定义异常
     *
     * @param exception ex
     * @return r
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResultEntity jsonErrorHandler(Throwable exception) {
        exception.printStackTrace();
        return ResultEntityBuilder.failure(exception.getMessage());
    }

    /**
     * 这个异常必须要放在最后，开发阶段直接把异常信息显示在页面上，更方便
     *
     * @param exception exception
     * @return r
     */
    @ExceptionHandler(Throwable.class)
    public ResultEntity handleException(Throwable exception) {
        exception.printStackTrace();
        return ResultEntityBuilder.failure(exception.getMessage());
    }

}
