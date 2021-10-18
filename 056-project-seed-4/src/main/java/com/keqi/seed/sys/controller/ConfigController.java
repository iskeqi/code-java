package com.keqi.seed.sys.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.db.ConfigDO;
import com.keqi.seed.sys.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sys/config")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @PostMapping
    public void insert(@RequestBody ConfigDO param) {
        configService.insert(param);
    }

    @DeleteMapping("/{configKey}")
    public void deleteByConfigKey(@PathVariable String configKey) {
        configService.deleteByConfigKey(configKey);
    }

    @PutMapping
    public void updateByConfigKey(@RequestBody ConfigDO param) {
        configService.updateByConfigKey(param);
    }

    @GetMapping
    public ConfigDO getByConfigKey(String configKey) {
        return configService.getByConfigKey(configKey);
    }

    @ApiOperationSupport(ignoreParameters = {
            "records", "total", "orders", "optimizeCountSql", "isSearchCount", "hitCount",
            "countId", "maxLimit", "searchCount", "searchName", "orderFiled", "orderType",
            "searchValue", "beginDate", "endDate", "beginTime", "endTime"})
    @GetMapping("/page")
    public PageVO<ConfigDO> page(Page<ConfigDO> param) {
        return configService.page(param);
    }
}
