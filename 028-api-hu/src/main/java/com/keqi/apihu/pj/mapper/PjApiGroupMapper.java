package com.keqi.apihu.pj.mapper;

import com.keqi.apihu.pj.domain.PjApiGroupDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PjApiGroupMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PjApiGroupDO record);

    int insertSelective(PjApiGroupDO record);

    PjApiGroupDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PjApiGroupDO record);

    int updateNameByPrimaryKey(PjApiGroupDO record);

    List<PjApiGroupDO> listChildById(Long id);

    List<PjApiGroupDO> listAll();

    void moveGroupOrder(@Param("list") List<PjApiGroupDO> pjApiGroupDOList);

    void deleteByIds(@Param("idList") List<Long> idList);
}