package com.keqi.grid.sys.controller;

import com.keqi.grid.sys.domain.db.DictItemDO;
import com.keqi.grid.sys.util.DictUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DictItemController {

    @Autowired
    private DictUtil dictUtil;

    @GetMapping("/sys/dictItem/typeCode")
    public List<DictItemDO> findByTypeCode(@RequestParam String typeCode) {
        return this.dictUtil.findByTypeCode(typeCode);
    }
}