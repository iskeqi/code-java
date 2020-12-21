package com.keqi.apihu.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.apihu.core.exception.BusinessException;
import com.keqi.apihu.core.pojo.PageVO;
import com.keqi.apihu.sys.domain.db.AccountProjectDO;
import com.keqi.apihu.sys.domain.db.ProjectDO;
import com.keqi.apihu.sys.domain.param.DesignatedAccountParam;
import com.keqi.apihu.sys.domain.param.ProjectPageParam;
import com.keqi.apihu.sys.domain.param.ProjectParam;
import com.keqi.apihu.sys.domain.vo.ProjectVO;
import com.keqi.apihu.sys.mapper.AccountProjectMapper;
import com.keqi.apihu.sys.mapper.ProjectMapper;
import com.keqi.apihu.sys.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;
    private final AccountProjectMapper accountProjectMapper;

    /**
     * 新增项目
     *
     * @param projectParam projectParam
     */
    @Override
    @Transactional
    public void insert(ProjectParam projectParam) {

        int total = this.projectMapper.countByProjectName(projectParam.getProjectName());
        if (total > 0) {
            throw new BusinessException("系统中已存在同名项目");
        }

        ProjectDO projectDO = new ProjectDO();
        BeanUtil.copyProperties(projectParam, projectDO);

        this.projectMapper.insert(projectDO);
    }

    /**
     * 根据ID修改项目
     *
     * @param projectParam projectParam
     */
    @Override
    @Transactional
    public void updateById(ProjectParam projectParam) {
        ProjectDO temp = this.projectMapper.getByProjectName(projectParam.getProjectName());
        if (temp != null && !Objects.equals(temp.getId(), projectParam.getId())) {
            throw new BusinessException("系统中已存在同名项目");
        }

        ProjectDO projectDO = new ProjectDO();
        BeanUtil.copyProperties(projectParam, projectDO);

        this.projectMapper.updateById(projectDO);
    }

    /**
     * 根据ID删除项目
     *
     * @param id id
     */
    @Override
    @Transactional
    public void deleteById(Long id) {
        // 逻辑删除
        this.projectMapper.disableProjectById(id);
    }

    /**
     * 分页查询项目列表
     *
     * @param pageParam pageParam
     * @return r
     */
    @Override
    public PageVO<ProjectVO> page(ProjectPageParam pageParam) {
        IPage<ProjectVO> result = this.projectMapper.page(new Page<>(pageParam.getCurrent(), pageParam.getSize()), pageParam);

        return new PageVO<>(result.getTotal(), result.getRecords());
    }

    /**
     * 指定项目人员
     *
     * @param designatedAccountParam designatedAccountParam
     */
    @Override
    @Transactional
    public void designatedAccount(DesignatedAccountParam designatedAccountParam) {
        Long projectId = designatedAccountParam.getProjectId();
        this.accountProjectMapper.deleteByProjectId(projectId);

        List<Long> accountIdList = designatedAccountParam.getAccountIdList();
        List<AccountProjectDO> list = new ArrayList<>(accountIdList.size());
        for (Long accountId : accountIdList) {
            AccountProjectDO t = new AccountProjectDO();
            t.setAccountId(accountId);
            t.setProjectId(projectId);
            list.add(t);
        }
        this.accountProjectMapper.insertList(list);
    }
}

