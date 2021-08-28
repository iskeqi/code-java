package com.keqi.seed.sys.service;

import com.keqi.seed.sys.domain.db.MenuDO;
import com.keqi.seed.sys.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public void insert(MenuDO param) {
        menuMapper.insert(param);
    }
}
