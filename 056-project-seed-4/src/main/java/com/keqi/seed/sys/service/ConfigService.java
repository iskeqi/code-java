package com.keqi.seed.sys.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.seed.core.exception.BusinessException;
import com.keqi.seed.core.pojo.PageVO;
import com.keqi.seed.sys.domain.db.ConfigDO;
import com.keqi.seed.sys.mapper.ConfigMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ConfigService {

    @Resource
    private ConfigMapper configMapper;

    public void insert(ConfigDO param) {
        ConfigDO t = this.getByConfigKey(param.getConfigKey());
        if (t != null) {
            throw new BusinessException("configKey：" + param.getConfigKey() + " 已经存在");
        }

        configMapper.insert(param);
    }

    public void deleteByConfigKey(String configKey) {
        configMapper.delete(Wrappers.query(new ConfigDO().setConfigKey(configKey)));
    }

    public void updateByConfigKey(ConfigDO param) {
        ConfigDO t = BeanUtil.copyProperties(param, ConfigDO.class);
        // configKey 是不能修改的
        t.setConfigKey(null);
        configMapper.update(t, Wrappers.query(new ConfigDO().setConfigKey(param.getConfigKey())));
    }

    public ConfigDO getByConfigKey(String configKey) {
        return configMapper.selectOne(Wrappers.query(new ConfigDO().setConfigKey(configKey)));
    }

    public PageVO<ConfigDO> page(Page<ConfigDO> param) {
        Page<ConfigDO> page = configMapper.selectPage(param, Wrappers.query());
        return new PageVO<>(page.getTotal(), page.getRecords());
    }
}
