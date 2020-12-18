package com.keqi.apihu.sys.service;

import com.keqi.apihu.core.pojo.PageVO;
import com.keqi.apihu.sys.domain.param.DictItemPageParam;
import com.keqi.apihu.sys.domain.param.DictItemParam;
import com.keqi.apihu.sys.domain.vo.DictItemVO;

import java.util.List;

public interface DictItemService {

    /**
     * 新增字典项
     *
     * @param dictItemParam dictItemParam
     */
    void insert(DictItemParam dictItemParam);

    /**
     * 根据ID修改字典项
     *
     * @param dictItemParam dictItemParam
     */
    void updateById(DictItemParam dictItemParam);

    /**
     * 根据ID删除字典项
     *
     * @param id id
     */
    void deleteById(Long id);

    /**
     * 分页查询字典项列表
     *
     * @param pageParam pageParam
     * @return r
     */
    PageVO<DictItemVO> page(DictItemPageParam pageParam);

    /**
     * 根据 typeCode 查询字典项列表
     *
     * @param typeCode typeCode
     * @return r
     */
    List<DictItemVO> listAllByTypeCode(String typeCode);
}
