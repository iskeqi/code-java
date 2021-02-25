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
                // 建议把 hasRole 替换成 hasAuthority，controller中方法的注解也是一样(理解有误)
                // 一个是角色，一个是权限，从使用的角度来说是不一样的，虽然他们最终是到同一个数组中找权限（实现相同）
                // 一个是直接针对角色一个是直接针对权限
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
        // 也就是说，使用 hasAuthority 更具有一致性，你不用考虑要不要加 ROLE_ 前缀，
        // 数据库什么样这里就是什么样！而 hasRole 则不同，代码里如果写的是 admin，
        // 框架会自动加上 ROLE_ 前缀，所以数据库就必须是 ROLE_admin。
        hierarchy.setHierarchy("ROLE_admin > ROLE_user");
        return hierarchy;
    }
}
