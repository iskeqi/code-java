package com.keqi.formsession;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@RestController
@SpringBootApplication
public class FormSessionApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormSessionApplication.class, args);
    }

    @GetMapping("/test1")
    public String test1(HttpServletRequest request, @CookieValue("JSESSIONID") String JSESSIONID) {
        /*
            SpringSecurity 默认的登录实现机制就是使用的 Cookie-Session 机制来实现的，
            如果是是十年前的那种前后端代码在一个工程下的web应用，默认的实现机制，其实已经完全能够满足需求了。毕竟登录、过滤器、注销都已经提供了默认实现。

            但是对于今天的 web 应用来说，已经不适用了，不建议这样使用哦，至于 SpringSession 项目更是没有使用的必要
         */

        HttpSession session = request.getSession();
        SecurityContext securityContext = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
        // org.springframework.security.authentication.UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) securityContext.getAuthentication();
        // org.springframework.security.core.userdetails.User
        User principal = (User) usernamePasswordAuthenticationToken.getPrincipal();
        String username = principal.getUsername();
        Collection<GrantedAuthority> authorities1 = principal.getAuthorities();
        Collection<GrantedAuthority> authorities = usernamePasswordAuthenticationToken.getAuthorities();

        /*
            通过以上代码，可以发现默认情况下，SpringSecurity 会把登录用户信息放到 session 中存储，并且在每个线程对应的 HttpSession 对象
            的attribute 中设置一个 key 为 SPRING_SECURITY_CONTEXT ，value 为SecurityContext的对象。
            这个 SecurityContext 对象中的 Authentication 对象则包含了 存放用户信息的 User 对象，以及存放用户角色/权限信息的
            Collection<GrantedAuthority> 对象

         */

        /*
        通过 org.springframework.security.core.context.SecurityContextHolder 类可以得到当前登录用户信息
        本质上就是通过 threadlocal 存储在了当前线程对象里面
         */
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsernamePasswordAuthenticationToken loginUser = (UsernamePasswordAuthenticationToken) authentication;
        User principal1 = (User) loginUser.getPrincipal();

        System.out.println(request.toString());
        System.out.println(JSESSIONID);

        return "test1";
    }
}
