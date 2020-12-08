package com.keqi.knife4j.sys.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.param.DictItemPageParam;
import com.keqi.knife4j.sys.domain.param.DictItemParam;
import com.keqi.knife4j.sys.domain.vo.DictItemVO;
import com.keqi.knife4j.sys.service.DictItemService;
import com.keqi.knife4j.sys.util.DictUtil;
import com.keqi.knife4j.core.util.JsonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "2. 字典项管理")
@ApiSupport(order = 2)
@AllArgsConstructor
@RestController
@RequestMapping("/sys/dictItem")
public class DictItemController {

    private final DictItemService dictItemService;

    @ApiOperation(value = "2.1 新增字典项")
    @ApiOperationSupport(order = 1, ignoreParameters = "dictItemParam.id")
    @PostMapping("/create")
    public void create(@RequestBody DictItemParam dictItemParam) {
        this.dictItemService.insert(dictItemParam);
    }

    @ApiOperation(value = "2.2 根据ID修改字典项")
    @ApiOperationSupport(order = 2)
    @PostMapping("/updateById")
    public void updateById(@RequestBody DictItemParam dictItemParam) {
        this.dictItemService.updateById(dictItemParam);
    }

    @ApiOperation(value = "2.3根据ID删除字典项")
    @ApiOperationSupport(order = 3)
    @ApiImplicitParam(name = "id", value = "字典项ID", example = "1", required = true)
    @PostMapping("/deleteById")
    public void deleteById(@RequestParam Long id) {
        this.dictItemService.deleteById(id);
    }

    @ApiOperation(value = "2.4 分页查询字典项列表")
    @ApiOperationSupport(order = 4)
    @PostMapping("/page")
    public PageVO<DictItemVO> page(@RequestBody DictItemPageParam pageParam) {
        return this.dictItemService.page(pageParam);
    }

    @ApiOperation(value = "2.5 根据 typeCode 查询字典项列表")
    @ApiOperationSupport(order = 5)
    @ApiImplicitParam(name = "typeCode", value = "字典类型Code", example = "gender", required = true)
    @GetMapping("/listAllByTypeCode")
    public List<DictItemVO> listAllByTypeCode(@RequestParam String typeCode) {
        return this.dictItemService.listAllByTypeCode(typeCode);
    }

    @ApiOperation(value = "2.6 获取所有字典类型对应的字典项JSON结构")
    @ApiOperationSupport(order = 6)
    @GetMapping("/getAllDictItem")
    public String getAllDictItem() {
        Map<String, List<DictItemVO>> dictMap = DictUtil.getDictMap();
        return JsonUtil.writeValueAsString(dictMap);
    }
}
