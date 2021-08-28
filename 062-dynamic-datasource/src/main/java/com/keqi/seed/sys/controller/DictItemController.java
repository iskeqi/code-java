package com.keqi.seed.sys.controller;

import com.keqi.seed.sys.domain.db.DictItemDO;
import com.keqi.seed.sys.service.DictItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sys/dict")
public class DictItemController {

    @Autowired
    private DictItemService dictItemService;

    @PostMapping
    public DictItemDO insert(@RequestBody DictItemDO param) {
        return dictItemService.insert(param);
    }

    @GetMapping("/{typeCode}")
    public List<DictItemDO> listByTypeCode(@PathVariable String typeCode) {
        return dictItemService.listByTypeCode(typeCode);
    }
}
