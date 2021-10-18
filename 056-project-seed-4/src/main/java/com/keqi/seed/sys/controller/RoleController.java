package com.keqi.seed.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.db.RoleDO;
import com.keqi.seed.sys.domain.param.RolePageParam;
import com.keqi.seed.sys.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "角色管理")
@RestController
@RequestMapping("/sys/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("新增角色")
    @PostMapping
    public void insert(@RequestBody RoleDO param) {
        roleService.insert(param);
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        roleService.deleteById(id);
    }

    @ApiOperation("修改角色")
    @PutMapping
    public void updateById(@RequestBody RoleDO param) {
        roleService.updateById(param);
    }

    @ApiOperation("查询角色详情")
    @GetMapping
    public RoleDO getById(String id) {
        return roleService.getById(id);
    }

    @ApiOperation("分页查询角色列表")
    @ApiOperationSupport(ignoreParameters = {
            "records", "total", "orders", "optimizeCountSql", "isSearchCount", "hitCount",
            "countId", "maxLimit", "searchCount", "searchName", "orderFiled", "orderType",
            "searchValue", "beginDate", "endDate", "beginTime", "endTime"})
    @GetMapping("/page")
    public PageVO<RoleDO> page(RolePageParam param) {
        return roleService.page(param);
    }

    // 给角色赋予权限
}
