package com.qjzh.idomp.zjc.sc.service;

import com.qjzh.idomp.zjc.sc.domain.DictDataVO;

import java.util.List;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author keqi
 * @since 2020-02-03
 */
public interface DictDataService {

    /**
     * 查询指定dictType对应的字典数据列表
     * @param dictType dictType
     * @return r
     */
    List<DictDataVO> listByDictType(String dictType);
}
