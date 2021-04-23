package com.keqi.springbootmvctrain.web;

import com.keqi.springbootmvctrain.exception.BusinessException;
import com.keqi.springbootmvctrain.exception.NoAuthException;
import com.keqi.springbootmvctrain.exception.OfflineException;
import com.keqi.springbootmvctrain.response.ResultEntity;
import com.keqi.springbootmvctrain.response.ResultEntityBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * 全局异常处理器(SpringMVC 中此类可以存在多个，可根据实际情况进行扩展)
 *
 * @author keqi
 */
@Slf4j
/*@ControllerAdvice
@ResponseBody*/
@RestControllerAdvice
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
	 * 未登录异常
	 *
	 * @return r
	 */
	@ExceptionHandler(value = NoAuthException.class)
	public ResultEntity noAuthException() {
		return ResultEntityBuilder.noAuth(null);
	}

	/**
	 * 已下线异常
	 *
	 * @return r
	 */
	@ExceptionHandler(value = OfflineException.class)
	public ResultEntity offlineException(OfflineException e) {
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
			return ResultEntityBuilder.failure("服务器有点累，请联系系统管理员");
		}

		// 开发阶段，直接将异常信息通过接口响应出去，便于排查问题
		return ResultEntityBuilder.failure(e.toString());
	}

}
