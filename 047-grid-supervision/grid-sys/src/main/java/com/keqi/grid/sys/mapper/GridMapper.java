package com.keqi.grid.sys.mapper;

import com.keqi.grid.core.pojo.BaseMapper;
import com.keqi.grid.sys.domain.db.GridDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GridMapper extends BaseMapper<GridDO> {

    List<GridDO> findAll();

    List<GridDO> findSubListByIds(@Param("gridIds") List<Long> gridIds);

    int countByParentId(Long gridId);
}