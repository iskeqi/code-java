package com.keqi.iotplatform.core.exception;

import com.keqi.iotplatform.core.domain.AjaxEntity;
import com.keqi.iotplatform.core.domain.AjaxEntityBuilder;
import lombok.extern.slf4j.Slf4j;
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
		StringBuilder errorMsg = new StringBuilder();
		for (ObjectError allError : e.getBindingResult().getAllErrors()) {
			errorMsg.append(allError.getDefaultMessage()).append(",");
		}
		errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
		return AjaxEntityBuilder.failure(errorMsg.toString());
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
	 * 使用@Validated注解验证方法参数中的@RequestParam注解和@PathVariable注解对应的值，抛出的是这种异常
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public AjaxEntity handleConstraintViolationException(ConstraintViolationException e) {
		e.printStackTrace();
		StringBuilder errorMsg = new StringBuilder();
		for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
			errorMsg.append(constraintViolation.getMessage()).append(",");
		}
		errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
		return AjaxEntityBuilder.failure(errorMsg.toString());
	}

	/**
	 * 自定义异常
	 *
	 * @param exception ex
	 * @return r
	 */
	@ExceptionHandler(value = CustomerException.class)
	public AjaxEntity jsonErrorHandler(Throwable exception) {
		exception.printStackTrace();
		return AjaxEntityBuilder.failure(exception.getMessage());
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
