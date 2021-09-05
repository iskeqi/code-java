package com.keqi.seed.web;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 动态切换数据源
 *
 * @author keqi
 */
@Slf4j
public class DynamicDatasourceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String tenantIdentifier = request.getHeader("tenantIdentifier");
        // todo 判断当前操作用户是否属于当前租户，如不属于，直接 return false
        SaTokenInfo userInfo = StpUtil.getTokenInfo();

        if (!StringUtils.hasText(tenantIdentifier)) {
            return false;
        }

        DynamicDataSourceContextHolder.push(tenantIdentifier);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        DynamicDataSourceContextHolder.clear();
    }

}
