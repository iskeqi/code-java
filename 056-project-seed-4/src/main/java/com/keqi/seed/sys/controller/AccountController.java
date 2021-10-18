package com.keqi.seed.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.db.AccountDO;
import com.keqi.seed.sys.domain.param.AccountPageParam;
import com.keqi.seed.sys.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理")
@RestController
@RequestMapping("/sys/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ApiOperation("新增用户")
    @PostMapping
    public void insert(@RequestBody AccountDO param) {
        accountService.insert(param);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        accountService.deleteById(id);
    }

    @ApiOperation("修改用户")
    @PutMapping
    public void updateById(@RequestBody AccountDO param) {
        accountService.updateById(param);
    }

    @ApiOperation("查询用户详情")
    @GetMapping
    public AccountDO getById(String id) {
        return accountService.getById(id);
    }

    @ApiOperation("分页查询用户列表")
    @ApiOperationSupport(ignoreParameters = {
            "records", "total", "orders", "optimizeCountSql", "isSearchCount", "hitCount",
            "countId", "maxLimit", "searchCount", "searchName", "orderFiled", "orderType",
            "searchValue", "beginDate", "endDate", "beginTime", "endTime"})
    @GetMapping("/page")
    public PageVO<AccountDO> page(AccountPageParam param) {
        return accountService.page(param);
    }

    // 给用户赋予角色
}
