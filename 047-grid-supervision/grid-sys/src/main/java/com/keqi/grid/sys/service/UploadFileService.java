package com.keqi.grid.sys.service;

import com.keqi.grid.core.pojo.PageVO;
import com.keqi.grid.sys.domain.param.UploadFilePageParam;
import com.keqi.grid.sys.domain.param.UploadFileParam;
import com.keqi.grid.sys.domain.vo.UploadFileVO;

public interface UploadFileService {

	void insert(UploadFileParam param);

	void updateById(UploadFileParam param);

	void deleteById(Long id);

	PageVO<UploadFileVO> page(UploadFilePageParam param);
}