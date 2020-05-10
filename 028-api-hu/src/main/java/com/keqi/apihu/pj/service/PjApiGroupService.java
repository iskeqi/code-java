package com.keqi.apihu.pj.service;

import com.keqi.apihu.pj.domain.PjApiGroupDO;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Validated
public interface PjApiGroupService{

    void deleteByPrimaryKey(Long id);

    int create(PjApiGroupDO record);

    int insertSelective(PjApiGroupDO record);

    PjApiGroupDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PjApiGroupDO record);

    void updateNameByPrimaryKey(PjApiGroupDO record);

    List<PjApiGroupDO> list();

    void moveGroupOrder(@NotEmpty List<PjApiGroupDO> pjApiGroupDOList);
}
