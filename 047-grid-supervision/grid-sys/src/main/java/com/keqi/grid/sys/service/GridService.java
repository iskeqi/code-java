package com.keqi.grid.sys.service;

import com.keqi.grid.sys.domain.vo.GridVO;

import java.util.List;

public interface GridService {

    List<GridVO> findTreeAll();

    /**
     * 查询指定用户本级及其子级的网格 id
     *
     * @param accountId
     * @return
     */
    List<Long> findGridIdsByUserId(Long accountId);

    boolean whetherTheBottomGrid(Long gridId);
}