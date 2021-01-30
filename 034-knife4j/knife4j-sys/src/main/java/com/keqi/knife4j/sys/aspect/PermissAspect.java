package com.keqi.knife4j.sys.aspect;

import com.keqi.knife4j.core.auth.Auth;
import com.keqi.knife4j.core.exception.BusinessException;
import com.keqi.knife4j.core.util.CommonUtil;
import com.keqi.knife4j.sys.domain.vo.MenuVO;
import com.keqi.knife4j.sys.mapper.MenuMapper;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * `@RequiresPermissions` 注解切面类
 *
 * @author keqi
 */
@AllArgsConstructor
@Aspect
@Component
public class PermissAspect {

	private final MenuMapper menuMapper;

	/**
	 * 配置织入点
	 */
	@Pointcut("@annotation(com.keqi.knife4j.sys.aspect.Permiss)")
	public void aspect() {
	}

	/**
	 * 验证当前操作用户是否有操作此接口的权限
	 *
	 * @param joinPoint joinPoint
	 */
	@Before("aspect()")
	public void before(JoinPoint joinPoint) {
		// 从loginUserBO 对象中取出当前登录用户拥有的权限列表，判断是否全部满足 permiss 注解中指定的权限列表
		// 满足则通过，不满足则直接抛异常，以中断当前请求
		// throw new BusinessException("您无此操作权限");

		Permiss permiss = CommonUtil.getAnnotation(joinPoint, Permiss.class);
		String[] permissList = permiss.value();
		Long accountId = Auth.getLoginAccountId();
		List<MenuVO> menuVOList = this.menuMapper.listByAccountId(accountId);

		boolean flag = false;
		for (String permissStr : permissList) {
			flag = false;
			for (MenuVO t : menuVOList) {
				if (permissStr.equals(t.getPermiss())) {
					flag = true;
					break;
				}
			}
		}
		if (!flag) {
			throw new BusinessException("您无此操作权限");
		}
	}
}
