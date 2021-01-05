package com.keqi.knife4j.core.exception;

import com.keqi.knife4j.core.response.ResultEntity;
import com.keqi.knife4j.core.response.ResultEntityBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

/**
 * 全局异常处理器
 *
 * @author keqi
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	/**
	 * 使用 @Validated 校验方法参数中的 @RequestBody 修饰的实体类，抛出的是这种异常
	 * 使用 @Valid 校验方法参数中的 @RequestBody 修饰的实体类，抛出的是这种异常(嵌套多层次校验)
	 * <p>
	 * 总结：使用了 @RequestBody 修饰参数，抛出的就是此种异常
	 *
	 * @param e MethodArgumentNotValidException
	 * @return r
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResultEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
		StringBuilder errorMsg = new StringBuilder();
		for (ObjectError allError : e.getBindingResult().getAllErrors()) {
			errorMsg.append(allError.getDefaultMessage()).append(",");
		}
		errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
		return ResultEntityBuilder.failure(errorMsg.toString());
	}

	/**
	 * 使用 @Validated 校验方法参数中的 @RequestParam 和 @PathVariable 修饰的参数，抛出的是这种异常(无论方法是 GET 还是 POST)
	 * Controller 方法中没有显式使用 @RequestParam 修饰的非实体类参数，同样抛出的是此种异常
	 * <p>
	 * 总结：使用了 @RequestParam/@PathVariable 修饰参数，抛出的就是此种异常
	 *
	 * @param e ConstraintViolationException
	 * @return r
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResultEntity constraintViolationException(ConstraintViolationException e) {
		StringBuilder errorMsg = new StringBuilder();
		for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
			errorMsg.append(constraintViolation.getMessage()).append(",");
		}
		errorMsg.delete(errorMsg.length() - 1, errorMsg.length());
		return ResultEntityBuilder.failure(errorMsg.toString());
	}

	/**
	 * 使用 @Validated 校验方法参数中的实体类参数，抛出的是此种异常(无论方法是 GET 还是 POST)
	 * <p>
	 * (不建议使用这种方式传递参数)
	 *
	 * @param e BindException
	 * @return r
	 */
	@ExceptionHandler(value = BindException.class)
	public ResultEntity bindException(BindException e) {
		StringBuilder errorMsg = new StringBuilder();
		for (ObjectError allError : e.getBindingResult().getAllErrors()) {
			errorMsg.append(allError.getDefaultMessage()).append(",");
		}
		errorMsg.delete(errorMsg.length() - 1, errorMsg.length());

		return ResultEntityBuilder.failure(errorMsg.toString());
	}

	/**
	 * 自定义异常
	 *
	 * @param e BusinessException
	 * @return r
	 */
	@ExceptionHandler(value = BusinessException.class)
	public ResultEntity businessException(BusinessException e) {
		return ResultEntityBuilder.failure(e.getMessage());
	}

	/**
	 * 未登录异常
	 *
	 * @return r
	 */
	@ExceptionHandler(value = NoAuthException.class)
	public ResultEntity noAuthException() {
		return ResultEntityBuilder.noAuth();
	}

	/**
	 * 这个异常必须要放在最后，开发阶段直接把异常信息显示在页面上，更方便调试程序
	 *
	 * @param e Throwable
	 * @return r
	 */
	@ExceptionHandler(Throwable.class)
	public ResultEntity throwable(Throwable e) {
		// 未知异常，打印异常栈信息便于排查问题
		log.info(e.getMessage(), e);
		return ResultEntityBuilder.failure(e.getMessage());
	}

}
