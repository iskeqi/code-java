package com.keqi.apihu.sys.mapper;

import com.keqi.apihu.sys.domain.db.AccountProjectDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountProjectMapper {

    /**
     * 根据 projectId 删除对应记录
     *
     * @param projectId projectId
     * @return r
     */
    int deleteByProjectId(@Param("projectId") Long projectId);

    /**
     * 批量新增用户-项目关联记录
     *
     * @param list list
     * @return r
     */
    int insertList(@Param("list") List<AccountProjectDO> list);


}