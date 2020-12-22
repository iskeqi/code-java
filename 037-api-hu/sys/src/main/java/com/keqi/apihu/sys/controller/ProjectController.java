package com.keqi.apihu.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.apihu.core.pojo.PageVO;
import com.keqi.apihu.sys.domain.param.DesignatedAccountParam;
import com.keqi.apihu.sys.domain.param.ProjectPageParam;
import com.keqi.apihu.sys.domain.param.ProjectParam;
import com.keqi.apihu.sys.domain.vo.ProjectVO;
import com.keqi.apihu.sys.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "4. 项目管理")
@ApiSupport(order = 4)
@AllArgsConstructor
@RestController
@RequestMapping("/sys/project")
public class ProjectController {

    private final ProjectService projectService;

    @ApiOperation(value = "4.1 新增项目")
    @ApiOperationSupport(order = 1, ignoreParameters = "ProjectParam.id")
    @PostMapping("/create")
    public void create(@RequestBody ProjectParam ProjectParam) {
        this.projectService.insert(ProjectParam);
    }

    @ApiOperation(value = "4.2 根据ID修改项目")
    @ApiOperationSupport(order = 2)
    @PostMapping("/updateById")
    public void updateById(@RequestBody ProjectParam ProjectParam) {
        this.projectService.updateById(ProjectParam);
    }

    @ApiOperation(value = "4.3 根据ID删除项目")
    @ApiOperationSupport(order = 3)
    @ApiImplicitParam(name = "id", value = "项目ID", example = "1", required = true)
    @PostMapping("/deleteById")
    public void deleteById(@RequestParam Long id) {
        this.projectService.deleteById(id);
    }

    @ApiOperation(value = "4.4 分页查询项目列表")
    @ApiOperationSupport(order = 4)
    @PostMapping("/page")
    public PageVO<ProjectVO> page(@RequestBody ProjectPageParam pageParam) {
        return this.projectService.page(pageParam);
    }

    @ApiOperation(value = "4.5 指定项目人员")
    @ApiOperationSupport(order = 5)
    @PostMapping("/designatedAccount")
    public void designatedAccount(@Validated @RequestBody DesignatedAccountParam designatedAccountParam) {
        this.projectService.designatedAccount(designatedAccountParam);
    }
}
