package com.keqi.seed.web;

import com.keqi.seed.core.exception.BusinessException;
import com.keqi.seed.core.exception.ValidatorException;
import com.keqi.seed.core.response.ResultEntity;
import com.keqi.seed.core.response.ResultEntityBuilder;
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
	 * SpringValidatorException
	 *
	 * @return r
	 */
	@ExceptionHandler(value = ValidatorException.class)
	public ResultEntity springValidatorException() {
		return ResultEntityBuilder.failure(null);
	}

	/**
	 * 这个异常必须要放在最后
	 *
	 * @param e Throwable
	 * @return r
	 */
	@ExceptionHandler(Throwable.class)
	public ResultEntity throwable(Throwable e) {
		// 未知异常，打印异常栈信息便于排查问题
		log.error(e.getMessage(), e);

		if ("prod".equals(active)) {
			// 邮件、微信、钉钉通知相关责任人
			return ResultEntityBuilder.failure("服务器有点累，请联系系统管理员");
		}

		// 开发阶段，直接将异常信息通过接口响应出去，便于排查问题
		return ResultEntityBuilder.failure(e.toString());
	}

}
