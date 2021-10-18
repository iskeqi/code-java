package com.keqi.seed.sys.controller;

import com.keqi.seed.sys.domain.db.DictItemDO;
import com.keqi.seed.sys.service.DictItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "字典管理")
@RestController
@RequestMapping("/sys/dict")
public class DictItemController {

    @Autowired
    private DictItemService dictItemService;

    @ApiOperation("新增字典")
    @PostMapping
    public DictItemDO insert(@RequestBody DictItemDO param) {
        return dictItemService.insert(param);
    }

    @ApiOperation("查询指定typeCode对应的配置项")
    @GetMapping("/{typeCode}")
    public List<DictItemDO> listByTypeCode(@PathVariable String typeCode) {
        return dictItemService.listByTypeCode(typeCode);
    }
}
