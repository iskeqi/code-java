package com.keqi.knife4j.sys.service.impl;

import com.keqi.knife4j.sys.domain.db.UploadFileDO;
import com.keqi.knife4j.sys.mapper.UploadFileMapper;
import com.keqi.knife4j.sys.service.UploadFileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class UploadFileServiceImpl implements UploadFileService {

    private final UploadFileMapper uploadFileMapper;

    /**
     * 增加
     *
     * @param t t
     */
    @Override
    @Transactional
    public void insert(UploadFileDO t) {
        this.uploadFileMapper.insert(t);
    }

    /**
     * 根据 id 获取对象
     *
     * @param id id
     * @return r
     */
    @Override
    public UploadFileDO getById(Long id) {
        return this.uploadFileMapper.getById(id);
    }
}
