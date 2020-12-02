package com.keqi.bestpracticeone.sys.controller;

import com.alibaba.fastjson.JSON;
import com.keqi.bestpracticeone.core.pojo.PageVO;
import com.keqi.bestpracticeone.sys.domain.param.DictItemPageParam;
import com.keqi.bestpracticeone.sys.domain.param.DictItemParam;
import com.keqi.bestpracticeone.sys.domain.vo.DictItemVO;
import com.keqi.bestpracticeone.sys.service.DictItemService;
import com.keqi.bestpracticeone.sys.util.DictUtil;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/sys/dictItem")
public class DictItemController {

    private final DictItemService dictItemService;

    /**
     * 新增字典项
     *
     * @param dictItemParam dictItemParam
     */
    @PostMapping("/create")
    public void create(@RequestBody DictItemParam dictItemParam) {
        this.dictItemService.create(dictItemParam);
    }

    /**
     * 根据ID修改字典项
     *
     * @param dictItemParam dictItemParam
     */
    @PostMapping("/updateById")
    public void updateById(@RequestBody DictItemParam dictItemParam) {
        this.dictItemService.updateById(dictItemParam);
    }

    /**
     * 根据ID删除字典项
     *
     * @param id id
     */
    @PostMapping("/deleteById")
    public void deleteById(Long id) {
        this.dictItemService.deleteById(id);
    }

    /**
     * 分页查询字典项列表
     *
     * @param pageParam pageParam
     * @return r
     */
    @PostMapping("/page")
    public PageVO<DictItemVO> page(@RequestBody DictItemPageParam pageParam) {
        return this.dictItemService.page(pageParam);
    }

    /**
     * 根据 typeCode 查询字典项列表
     *
     * @param typeCode typeCode
     * @return r
     */
    @GetMapping("/listAllByTypeCode")
    public List<DictItemVO> listAllByTypeCode(@RequestParam String typeCode) {
        return this.dictItemService.listAllByTypeCode(typeCode);
    }

    /**
     * 获取所有字典类型对应的字典项JSON结构
     *
     * @return r
     */
    @GetMapping("/getAllDictItem")
    public String getAllDictItem() {
        Map<String, List<DictItemVO>> dictMap = DictUtil.getDictMap();
        return JSON.toJSONString(dictMap);
    }
}
