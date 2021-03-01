package com.keqi.seed.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.aspect.Permiss;
import com.keqi.seed.sys.domain.param.AccountCreateParam;
import com.keqi.seed.sys.domain.param.AccountPageParam;
import com.keqi.seed.sys.domain.param.AccountUpdateParam;
import com.keqi.seed.sys.domain.vo.AccountVO;
import com.keqi.seed.sys.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "4. 用户管理")
@ApiSupport(order = 4)
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation(value = "4.1 新增用户")
    @ApiOperationSupport(order = 1)
    @PostMapping("/sys/account")
    public void insert(@Validated @RequestBody AccountCreateParam param) {
        this.accountService.insert(param);
    }

    @ApiOperation(value = "5.2 修改用户")
    @ApiOperationSupport(order = 2)
    @PutMapping("/sys/account")
    public void updateById(@Validated @RequestBody AccountUpdateParam param) {
        this.accountService.updateById(param);
    }

    @ApiOperation(value = "5.3 删除用户")
    @ApiOperationSupport(order = 3)
    @ApiImplicitParam(name = "id", value = "用户ID", example = "1", required = true)
    @DeleteMapping("/sys/account/{id}")
    public void deleteById(@PathVariable Long id) {
        this.accountService.deleteById(id);
    }

    @ApiOperation(value = "5.4 分页查询用户列表")
    @ApiOperationSupport(order = 4)
    @GetMapping("/sys/account/page")
    public PageVO<AccountVO> page(AccountPageParam param) {
        return this.accountService.page(param);
    }
}
