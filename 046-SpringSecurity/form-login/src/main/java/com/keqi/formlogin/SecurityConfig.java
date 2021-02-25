package com.keqi.formlogin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder() {
        // 配置一个不会加密明文密码的示例
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("123456")
                .roles("admin");
    }

    @Override
    public void configure(WebSecurity web) {
        // 放行指定路径
        web.ignoring().antMatchers("/js/**", "/css/**","/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html") // 指定登录页面的请求 get
                // .loginProcessingUrl("/login.html") // 指定登录接口的地址： post + username/password（也可以不配置，默认和登录页面地址相同）
                // .usernameParameter("username") // 指定账号字段的参数值
                // .passwordParameter("password") // 指定密码字段的参数值
                // .defaultSuccessUrl() // 登录成功回调接口地址
                // .successForwardUrl() // 登录成功回调地址
                // .failureUrl() // 登录失败回调
                // .failureForwardUrl() // 登录失败回调
                // 还有注销的各种各样的方式
                .permitAll()
                .and()
                .csrf().disable();
    }

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")
                .loginProcessingUrl("/doLogin")
                .usernameParameter("name")
                .passwordParameter("passwd")
                .defaultSuccessUrl("/index")
                .successForwardUrl("/index")
                .failureForwardUrl("/f2")
                .failureUrl("/f1")
                .permitAll()
                .and()
                .logout()
//                .logoutUrl("/logout")
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))
                .logoutSuccessUrl("/index")
                .deleteCookies()
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .permitAll()
                .and()
                .csrf().disable();
    }*/
}
