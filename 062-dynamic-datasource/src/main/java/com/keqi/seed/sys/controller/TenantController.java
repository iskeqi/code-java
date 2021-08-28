package com.keqi.seed.sys.controller;

import com.keqi.seed.sys.domain.db.TenantDO;
import com.keqi.seed.sys.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @PostMapping
    public void insert(@RequestBody TenantDO param) {
        tenantService.insert(param);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        tenantService.deleteById(id);
    }

    @PutMapping
    public void updateById(@RequestBody TenantDO param) {
        tenantService.updateById(param);
    }

    @GetMapping
    public TenantDO getById(String id) {
        return tenantService.getById(id);
    }
}
