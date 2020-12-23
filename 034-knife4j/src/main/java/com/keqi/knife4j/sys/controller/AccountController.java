package com.keqi.knife4j.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.knife4j.sys.domain.param.AccountParam;
import com.keqi.knife4j.sys.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = "4. 用户管理")
@ApiSupport(order = 4)
@AllArgsConstructor
@RestController
@RequestMapping("/sys/account")
public class AccountController {

    private final AccountService accountService;

    @ApiOperation(value = "4.1 新增用户")
    @ApiOperationSupport(order = 1)
    @PostMapping("/create")
    public void create(@RequestBody AccountParam accountParam) {
        this.accountService.insert(accountParam);
    }
}
