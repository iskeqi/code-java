package com.keqi.seed.web;

import cn.dev33.satoken.exception.*;
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
	 * BusinessException
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
			return ResultEntityBuilder.failure("系统繁忙，请稍后重试");
		}

		// 开发阶段，直接将异常信息通过接口响应出去，便于排查问题
		return ResultEntityBuilder.failure(e.toString());
	}

}
