package com.keqi.formlogin4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected UserDetailsService userDetailsService() {
        // SpringSecurity 支持多种数据源，比如内存、数据库、LDAP 等，这些不同来源的数据
        // 被共同封装成了一个 UserDetailService 接口，任何实现了该接口的对象，都可以作为认证数据源
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("javaboy").password("123").roles("admin").build());
        manager.createUser(User.withUsername("江南一点雨").password("123").roles("user").build());
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // 满足此规则的请求需要有 admin 权限
                .antMatchers("/admin/**").hasRole("admin")
                // 满足此规则的请求需要有 user 权限
                .antMatchers("/user/**").hasRole("user")
                // 其他请求只要通过登录认证即可
                .anyRequest().authenticated();
    }

    @Bean
    RoleHierarchy roleHierarchy() {
        // 角色继承
        // 在实际开发中可能会用得上，比如上级默认就有下级拥有的所有权限
        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
        // 这里的 ROLE_ 前缀，是 SpringSecurity 中默认会加上的前缀。谨记！！！
        hierarchy.setHierarchy("ROLE_admin > ROLE_user");
        return hierarchy;
    }
}
