package com.keqi.knife4j.sys.service;

import com.keqi.knife4j.sys.domain.db.UploadFileDO;

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
    UploadFileDO getById(Long id);

    /**
     * 根据 id 删除文件
     *
     * @param id id
     */
    void deleteById(Long id);
}
