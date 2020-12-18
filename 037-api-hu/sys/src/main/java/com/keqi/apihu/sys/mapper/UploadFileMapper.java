package com.keqi.apihu.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.apihu.sys.domain.db.UploadFileDO;

public interface UploadFileMapper extends BaseMapper<UploadFileDO> {

    /**
     * 根据 id 查询记录
     *
     * @param id id
     * @return r
     */
    UploadFileDO getById(Long id);
}