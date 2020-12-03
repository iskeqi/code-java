package com.keqi.bestpracticeone.sys.service;

import com.keqi.bestpracticeone.sys.domain.db.UploadFileDO;

public interface UploadFileService {


    /**
     * 增加
     *
     * @param t t
     */
    void insert(UploadFileDO t);

    /**
     * 根据 id 获取对象
     *
     * @param id id
     * @return r
     */
    UploadFileDO getById(String id);
}
