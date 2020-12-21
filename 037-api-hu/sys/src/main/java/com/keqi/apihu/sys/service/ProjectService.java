package com.keqi.apihu.sys.service;

import com.keqi.apihu.core.pojo.PageVO;
import com.keqi.apihu.sys.domain.param.DesignatedAccountParam;
import com.keqi.apihu.sys.domain.param.ProjectPageParam;
import com.keqi.apihu.sys.domain.param.ProjectParam;
import com.keqi.apihu.sys.domain.vo.ProjectVO;

public interface ProjectService {

    /**
     * 新增项目
     *
     * @param projectParam projectParam
     */
    void insert(ProjectParam projectParam);

    /**
     * 根据ID修改项目
     *
     * @param projectParam projectParam
     */
    void updateById(ProjectParam projectParam);

    /**
     * 根据ID删除项目
     *
     * @param id id
     */
    void deleteById(Long id);

    /**
     * 分页查询项目列表
     *
     * @param pageParam pageParam
     * @return r
     */
    PageVO<ProjectVO> page(ProjectPageParam pageParam);

    /**
     * 指定项目人员
     *
     * @param designatedAccountParam designatedAccountParam
     */
    void designatedAccount(DesignatedAccountParam designatedAccountParam);
}

