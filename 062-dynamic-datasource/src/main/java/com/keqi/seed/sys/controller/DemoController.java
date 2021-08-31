package com.keqi.seed.sys.controller;

import com.keqi.seed.sys.domain.db.RoleDO;
import com.keqi.seed.sys.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/assets/device")
public class DemoController {

    @Autowired
    private RoleMapper roleMapper;

    @PostMapping
    public List<RoleDO> test() {
        return roleMapper.selectList(null);
    }
}
