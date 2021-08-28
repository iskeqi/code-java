package com.keqi.seed.sys.controller;

import com.keqi.seed.sys.domain.db.MenuDO;
import com.keqi.seed.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping
    public void insert(@RequestBody MenuDO param) {
        menuService.insert(param);
    }

    // 根据用户 id 返回对应的菜单列表（需使用递归构造树形结构）
}
