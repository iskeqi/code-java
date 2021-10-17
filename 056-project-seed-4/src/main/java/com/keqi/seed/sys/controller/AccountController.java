package com.keqi.seed.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.db.AccountDO;
import com.keqi.seed.sys.domain.param.AccountPageParam;
import com.keqi.seed.sys.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public void insert(@RequestBody AccountDO param) {
        accountService.insert(param);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        accountService.deleteById(id);
    }

    @PutMapping
    public void updateById(@RequestBody AccountDO param) {
        accountService.updateById(param);
    }

    @GetMapping
    public AccountDO getById(String id) {
        return accountService.getById(id);
    }

    @ApiOperationSupport(ignoreParameters = {"records", "total", "orders", "optimizeCountSql",
            "isSearchCount", "hitCount", "countId", "maxLimit", "searchCount"})
    @GetMapping("/page")
    public PageVO<AccountDO> page(AccountPageParam param) {
        return accountService.page(param);
    }

    // 给用户赋予角色
}
