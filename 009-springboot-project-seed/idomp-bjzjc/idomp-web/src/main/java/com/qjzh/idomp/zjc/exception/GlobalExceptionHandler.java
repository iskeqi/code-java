package com.qjzh.idomp.zjc.exception;

import com.qjzh.idomp.zjc.core.common.AjaxEntity;
import com.qjzh.idomp.zjc.core.common.AjaxEntityBuilder;
import com.qjzh.idomp.zjc.core.execption.CustomerException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 全局异常处理器
 * @author keqi
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Throwable.class)
	@ResponseBody
	public AjaxEntity<Map<String, Object>> jsonErrorHandler(HttpServletRequest req, Throwable exception) throws Exception {
		// 打印异常栈信息
		exception.printStackTrace();

		// 自定义异常则显示异常对象中指定的描述信息
		if (exception instanceof CustomerException) {
			return AjaxEntityBuilder.failure(exception.getMessage());
		}

		// 非自定义异常则统一显示"系统内部错误"字样
		return AjaxEntityBuilder.failure("系统内部错误");
	}

}
