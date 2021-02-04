package com.keqi.seed.core.interceptor;

import cn.hutool.core.util.StrUtil;
import com.keqi.seed.core.auth.Auth;
import com.keqi.seed.core.auth.LoginUserBO;
import com.keqi.seed.core.exception.NoAuthException;
import com.keqi.seed.core.exception.OfflineException;
import com.keqi.seed.core.pojo.CommonConstant;
import com.keqi.seed.core.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 安全拦截器(进行token的鉴权等)
 *
 * @author keqi
 */
@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader(CommonConstant.TOKEN);
        if (StrUtil.isBlank(token)) {
            throw new NoAuthException();
        }

        String accountInfo = (String) stringRedisTemplate.opsForHash().get(CommonConstant.UUID_LOGIN_INFO, token);
        if (StrUtil.isBlank(accountInfo)) {
            // 去 set 中找，存在则是被其它用户挤下线的
            Boolean member = stringRedisTemplate.opsForSet().isMember(CommonConstant.UUID_LOGOUT_INFO, token);
            if (member) {
                stringRedisTemplate.opsForSet().remove(CommonConstant.UUID_LOGOUT_INFO, token);
                throw new OfflineException("当前账号已在其它设备上登录");
            }
            throw new NoAuthException();
        }

        LoginUserBO loginUserBO = JsonUtil.readValue(accountInfo, LoginUserBO.class);
        if (System.currentTimeMillis() > loginUserBO.getExpirationTime()) {
            stringRedisTemplate.execute(new SessionCallback<Object>() {
                @Override
                public <K, V> Object execute(RedisOperations<K, V> redisOperations) throws DataAccessException {
                    StringRedisTemplate template = (StringRedisTemplate) redisOperations;
                    template.multi();

                    template.opsForHash().delete(CommonConstant.UUID_LOGIN_INFO, loginUserBO.getToken());
                    template.opsForHash().delete(CommonConstant.ACCOUNT_LOGIN_INFO, loginUserBO.getAccount() + loginUserBO.getDevType());

                    return template.exec();
                }
            });
            throw new NoAuthException();
        }

        // 设置当前操作用户信息到当前线程对象中
        Auth.setLoginUserBO(loginUserBO);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        Auth.setLoginUserBO(null);
    }
}
