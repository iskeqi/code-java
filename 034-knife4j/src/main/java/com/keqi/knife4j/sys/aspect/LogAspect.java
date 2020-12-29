package com.keqi.knife4j.sys.aspect;

import cn.hutool.core.thread.ThreadUtil;
import com.keqi.knife4j.core.auth.Auth;
import com.keqi.knife4j.core.util.CommonUtil;
import com.keqi.knife4j.core.util.JsonUtil;
import com.keqi.knife4j.sys.domain.param.OperLogParam;
import com.keqi.knife4j.sys.service.OperLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * `@Log` 注解切面类
 *
 * @author keqi
 */
@Aspect
@Component
public class LogAspect {

	private static OperLogService operLogService;

	@Autowired
	public void setOperLogService(OperLogService operLogService) {
		LogAspect.operLogService = operLogService;
	}

	/**
	 * 配置织入点
	 */
	@Pointcut("@annotation(com.keqi.knife4j.sys.aspect.Log)")
	public void aspect() {
	}

	/**
	 * 记录此次 HTTP 请求的请求参数/响应参数等，并记录日志到 DB 中
	 *
	 * @param joinPoint joinPoint
	 */
	@AfterThrowing(pointcut = "aspect()", throwing = "e")
	public void after(JoinPoint joinPoint, Throwable e) {
		log(joinPoint, null, e);
	}

	/**
	 * 记录此次 HTTP 请求的请求参数/响应参数等，并记录日志到 DB 中
	 *
	 * @param joinPoint joinPoint
	 */
	@AfterReturning(pointcut = "aspect()", returning = "result")
	public void AfterReturning(JoinPoint joinPoint, Object result) {
		log(joinPoint, result, null);
	}

	/**
	 * 记录操作日志
	 *
	 * @param joinPoint joinPoint
	 * @param result    result
	 * @param e         e
	 */
	private void log(JoinPoint joinPoint, Object result, Throwable e) {
		HttpServletRequest request = CommonUtil.getCurrentRequest();
		String contentType = request.getContentType();
		String ip = CommonUtil.getRequestClientRealIP(request);
		String uri = request.getRequestURI();
		String type = request.getMethod();
		String param = JsonUtil.writeValueAsString(request.getParameterMap());
		String createBy = Auth.getLoginAccountName();

		// 开启一个新的线程插入操作记录至 DB 中
		ThreadUtil.execute(() -> {
			Log log = CommonUtil.getAnnotation(joinPoint, Log.class);
			String className = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();

			OperLogParam t = new OperLogParam();

			t.setCreateBy(createBy);
			t.setCreateTime(LocalDateTime.now());
			t.setIp(ip);
			t.setUrl(uri);
			t.setType(type);
			t.setName(log.value());
			t.setMethod(className + "." + methodName + "()");
			t.setContentType(contentType);

			// 设置响应参数
			if (e != null) {
				t.setSuccess(1);
				t.setResult(JsonUtil.writeValueAsString(e.getMessage()));
			} else {
				t.setResult(JsonUtil.writeValueAsString(result));
			}

			// 设置请求参数
			if ("application/json".equals(contentType)) {
				t.setParam(JsonUtil.writeValueAsString(joinPoint.getArgs()[0]));
			} else {
				t.setParam(param);
			}

			LogAspect.operLogService.insert(t);
		});
	}
}
