package com.keqi.satokenspringboot.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaCheckSafe;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class DemoController {

    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456&device=pc
    @RequestMapping("doLogin")
    public SaTokenInfo doLogin(String username, String password, String device) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(username) && "123456".equals(password)) {
            // 默认情况下是在内存中的 ConcurrentHashMap 中存储用户登录信息，并在后台控制写入cookie信息值浏览器中
            StpUtil.login(10001, device);
            // 关闭默认 session 的方式后，需要在登录接口返回 token
            return StpUtil.getTokenInfo();
        }
        return null;
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin(String username, String password) {
        return "当前会话是否登录：" + StpUtil.isLogin() + " " + StpUtil.getLoginIdAsString();
    }

    // 检查当前登录用户是否拥有某种权限，浏览器访问： http://localhost:8081/user/permission
    @RequestMapping("permission")
    public String permission(String username, String password) {
        return "当前登录登录用户是否拥有 123456 权限" + StpUtil.hasPermission("123456");
    }

    // 登录认证：只有登录之后才能进入该方法
    @SaCheckLogin
    @RequestMapping("info")
    public String info() {
        return "查询用户信息";
    }

    // 角色认证：必须具有指定角色才能进入该方法
    @SaCheckRole("super-admin")
    @RequestMapping("add1")
    public String add1() {
        return "用户增加";
    }

    // 权限认证：必须具有指定权限才能进入该方法
    @SaCheckPermission("user-add")
    @RequestMapping("add2")
    public String add2() {
        return "用户增加";
    }

    // 二级认证：必须二级认证之后才能进入该方法
    @SaCheckSafe()
    @RequestMapping("add3")
    public String add3() {
        return "用户增加";
    }

}
