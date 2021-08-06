package com.keqi.seed.sys.controller;

import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.db.RoleDO;
import com.keqi.seed.sys.domain.param.RolePageParam;
import com.keqi.seed.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public void insert(@RequestBody RoleDO param) {
        roleService.insert(param);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        roleService.deleteById(id);
    }

    @PutMapping
    public void updateById(@RequestBody RoleDO param) {
        roleService.updateById(param);
    }

    @GetMapping
    public RoleDO getById(String id) {
        return roleService.getById(id);
    }

    @GetMapping("/page")
    public PageVO<RoleDO> page(RolePageParam param) {
        return roleService.page(param);
    }

    // 给角色赋予权限
}
