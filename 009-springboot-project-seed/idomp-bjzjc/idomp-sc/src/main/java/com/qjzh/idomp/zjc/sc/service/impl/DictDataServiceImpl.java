package com.qjzh.idomp.zjc.sc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qjzh.idomp.zjc.sc.domain.DictDataDO;
import com.qjzh.idomp.zjc.sc.mapper.DictDataMapper;
import com.qjzh.idomp.zjc.sc.service.IDictDataService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author keqi
 * @since 2020-02-03
 */
@Service
@Slf4j
@AllArgsConstructor
public class DictDataServiceImpl extends ServiceImpl<DictDataMapper, DictDataDO> implements IDictDataService {

	private final DictDataMapper dictDataMapper;

}
