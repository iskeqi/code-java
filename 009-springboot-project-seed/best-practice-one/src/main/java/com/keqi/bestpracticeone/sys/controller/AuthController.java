package com.keqi.bestpracticeone.sys.controller;

import com.keqi.bestpracticeone.sys.domain.vo.LoginVO;
import com.keqi.bestpracticeone.sys.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/sys/auth")
public class AuthController {

    private final AccountService accountService;

    /**
     * 登录
     *
     * @param account  account
     * @param password password
     * @return r
     */
    @PostMapping("/login")
    public LoginVO login(@RequestParam String account, @RequestParam String password) {
        return this.accountService.login(account, password);
    }
}
