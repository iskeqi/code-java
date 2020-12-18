package com.keqi.apihu.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.apihu.sys.domain.db.DictItemDO;
import com.keqi.apihu.sys.domain.param.DictItemPageParam;
import com.keqi.apihu.sys.domain.vo.DictItemVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DictItemMapper extends BaseMapper<DictItemDO> {

    /**
     * 查询所有 TypeCode
     *
     * @return r
     */
    List<String> listAllTypeCode();

    /**
     * 根据 typeCode 查询对应的所有字典项
     *
     * @param typeCode typeCode
     * @return r
     */
    List<DictItemVO> listAllByTypeCode(String typeCode);

    /**
     * 分页查询字典项列表
     *
     * @param dictItemDOPage dictItemDOPage
     * @param pageParam      pageParam
     * @return r
     */
    IPage<DictItemVO> page(@Param("dictItemDOPage") Page<DictItemDO> dictItemDOPage, @Param("pageParam") DictItemPageParam pageParam);

    /**
     * 逻辑删除字典项
     *
     * @param id id
     * @return r
     */
    int disableById(Long id);

    /**
     * 一次性查询出所有字典项数据
     *
     * @return r
     */
    List<DictItemVO> listAll();


}