package com.qjzh.idomp.zjc.sc.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.qjzh.idomp.zjc.core.CommonConstants;
import com.qjzh.idomp.zjc.sc.domain.DictData;
import com.qjzh.idomp.zjc.sc.domain.DictDataVO;
import com.qjzh.idomp.zjc.sc.mapper.DictDataMapper;
import com.qjzh.idomp.zjc.sc.service.DictDataService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
public class DictDataServiceImpl implements DictDataService {

    private final DictDataMapper dictDataMapper;

    /**
     * 查询指定dictType对应的字典数据列表
     *
     * @param dictType dictType
     * @return r
     */
    @Override
    public List<DictDataVO> listByDictType(String dictType) {

        // 1、查询指定dictType对应的字典数据列表
        List<DictData> dictDataList = dictDataMapper.listByDictType(dictType);

        // 2、组装返回VO对象
        List<DictDataVO> dictDataVOList = new ArrayList<>();
        for (DictData dictData : dictDataList) {
            DictDataVO dictDataVO = new DictDataVO();
            BeanUtil.copyProperties(dictData, dictDataVO);
            dictDataVOList.add(dictDataVO);
        }

        return dictDataVOList;
    }

    /**
     * 删除dictType对应的字典数据列表
     *
     * @param dictType dictType
     */
    @Override
    @Transactional
    public void deleteByDictType(String dictType) {
        this.dictDataMapper.deleteByDictType(dictType);
    }

    /**
     * 批量增加字典数据
     *
     * @param dictDataList dictDataList
     */
    @Override
    @Transactional
    public void insertBatch(List<DictData> dictDataList) {
        for (DictData dictData : dictDataList) {
            this.insert(dictData);
        }
    }

    /**
     * 插入一条记录
     *
     * @param entity entity
     */
    @Override
    @Transactional
    public void insert(DictData entity) {
        entity.setActiveFlag(CommonConstants.ACTIVE_Y);
        this.dictDataMapper.insert(entity);
    }
}
