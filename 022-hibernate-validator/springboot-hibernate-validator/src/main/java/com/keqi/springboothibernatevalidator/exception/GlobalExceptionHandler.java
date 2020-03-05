package com.keqi.springboothibernatevalidator.exception;

import com.keqi.springboothibernatevalidator.common.AjaxEntity;
import com.keqi.springboothibernatevalidator.common.AjaxEntityBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;

/**
 * 全局异常处理器
 * @author keqi
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class GlobalExceptionHandler {

	/**
	 * 专治表单以及GET方式提交参数进行校验时的异常
	 */
	@ExceptionHandler(value = BindException.class)
	public AjaxEntity errorHandler(BindException e) {
		e.printStackTrace();
		// 有多个异常时直接凭借出来一次性给出
		StringBuilder errorMsg = new StringBuilder();
		for (ObjectError allError : e.getBindingResult().getAllErrors()) {
			errorMsg.append(allError.getDefaultMessage()).append(",");
		}
		errorMsg.delete(errorMsg.length() - 1, errorMsg.length());

		return AjaxEntityBuilder.failure(errorMsg.toString());
	}

	/**
	 * 专治请求体为JSON时提交参数进行校验时的异常
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public AjaxEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		e.printStackTrace();
		return AjaxEntityBuilder.failure(e.getBindingResult().getFieldError().getDefaultMessage());
	}

	/**
	 * ValidationException
	 */
	@ExceptionHandler({ValidationException.class})
	public AjaxEntity handleValidationException(ValidationException e) {
		e.printStackTrace();
		return AjaxEntityBuilder.failure(e.getCause().getMessage());
	}

	/**
	 * ConstraintViolationException
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public AjaxEntity handleConstraintViolationException(ConstraintViolationException e) {
		e.printStackTrace();
		return AjaxEntityBuilder.failure(e.getMessage());
	}

	/**
	 * 这个异常必须要放在最后
	 */
	@ExceptionHandler(Throwable.class)
	public AjaxEntity handleException(Throwable e) {
		e.printStackTrace();
		return AjaxEntityBuilder.failure("系统繁忙，请稍后再试");
	}



}
