package com.keqi.springsecurityjwt.web.security;

import com.keqi.springsecurityjwt.sys.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.time.Duration;
import java.util.Collections;

/**
 * SpringSecurity 配置类
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 登录或新增用户时需要调用此对象的 encode() 方法加密密码，matches() 方法匹配密码是否正确
     *
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    /**
     * 向 SpringSecurity 中注入 UserDetailService 对象
     *
     * @param auth auth
     * @throws Exception exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailServiceImpl());
    }

    /**
     * 放行指定路径
     *
     * @param web web
     * @throws Exception exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
    }

    /**
     * 跨域配置
     *
     * @return r
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedOrigins(Collections.singletonList("*"));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setMaxAge(Duration.ofHours(1));
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    MyUsernamePasswordAuthenticationFilter myUsernamePasswordAuthenticationFilter() throws Exception {
        MyUsernamePasswordAuthenticationFilter filter = new MyUsernamePasswordAuthenticationFilter();
        filter.setAuthenticationSuccessHandler(new MyLoginSuccessHandler());
        filter.setAuthenticationFailureHandler(new MyLoginFailureHandler());
        filter.setFilterProcessesUrl("/login");

        filter.setAuthenticationManager(authenticationManagerBean());
        return filter;
    }

    /**
     * SpringSecurity http 配置
     *
     * @param http http
     * @throws Exception exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 任何请求都需要认证
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                // 登录
                .formLogin()
                /*.successHandler(new MyLoginSuccessHandler())
                .failureHandler(new MyLoginFailureHandler())*/
                .permitAll()
                .and()
                // 注销
                .logout()
                .logoutSuccessHandler(new MyLogoutSuccessHandler())
                .permitAll()
                .and()
                .csrf().disable();

        http.addFilterAt(myUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterAfter(new TokenFilter(), LogoutFilter.class);
    }
}
