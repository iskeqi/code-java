package com.keqi.knife4j.sys.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.knife4j.core.pojo.PageVO;
import com.keqi.knife4j.sys.domain.db.DictItemDO;
import com.keqi.knife4j.sys.domain.param.DictItemPageParam;
import com.keqi.knife4j.sys.domain.param.DictItemParam;
import com.keqi.knife4j.sys.domain.vo.DictItemVO;
import com.keqi.knife4j.sys.mapper.DictItemMapper;
import com.keqi.knife4j.sys.service.DictItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class DictItemServiceImpl implements DictItemService {

    private final DictItemMapper dictItemMapper;

    /**
     * 新增字典项
     *
     * @param dictItemParam dictItemParam
     */
    @Override
    @Transactional
    public void insert(DictItemParam dictItemParam) {
        DictItemDO t = new DictItemDO();
        BeanUtils.copyProperties(dictItemParam, t);
        this.dictItemMapper.insert(t);
    }

    /**
     * 根据ID修改字典项
     *
     * @param dictItemParam dictItemParam
     */
    @Override
    @Transactional
    public void updateById(DictItemParam dictItemParam) {
        DictItemDO t = new DictItemDO();
        BeanUtils.copyProperties(dictItemParam, t);
        this.dictItemMapper.updateById(t);
    }

    /**
     * 根据ID删除字典项
     *
     * @param id id
     */
    @Override
    @Transactional
    public void deleteById(Long id) {
        // 逻辑删除
        this.dictItemMapper.disableById(id);
    }

    /**
     * 分页查询字典项列表
     *
     * @param pageParam pageParam
     * @return r
     */
    @Override
    public PageVO<DictItemVO> page(DictItemPageParam pageParam) {
        IPage<DictItemVO> result = this.dictItemMapper
                .page(new Page<>(pageParam.getCurrent(), pageParam.getSize()), pageParam);
        return new PageVO<>(result.getTotal(), result.getRecords());
    }

    /**
     * 根据 typeCode 查询字典项列表
     *
     * @param typeCode typeCode
     * @return r
     */
    @Override
    public List<DictItemVO> listAllByTypeCode(String typeCode) {
        return this.dictItemMapper.listAllByTypeCode(typeCode);
    }
}
