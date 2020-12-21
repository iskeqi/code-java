package com.keqi.apihu.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.keqi.apihu.sys.domain.db.ProjectDO;
import com.keqi.apihu.sys.domain.param.ProjectPageParam;
import com.keqi.apihu.sys.domain.vo.ProjectVO;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper extends BaseMapper<ProjectDO> {

    /**
     * 根据 projectName 查询总数
     *
     * @param projectName projectName
     * @return r
     */
    int countByProjectName(String projectName);

    /**
     * 根据 projectName 查询到项目对象
     *
     * @param projectName projectName
     * @return r
     */
    ProjectDO getByProjectName(@Param("projectName") String projectName);

    /**
     * 逻辑删除项目
     *
     * @param id id
     * @return r
     */
    int disableProjectById(Long id);

    IPage<ProjectVO> page(@Param("page") IPage<ProjectVO> page, @Param("projectPageParam") ProjectPageParam projectPageParam);
}