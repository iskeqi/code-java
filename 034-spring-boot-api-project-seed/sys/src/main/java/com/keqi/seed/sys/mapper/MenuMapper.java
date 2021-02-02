package com.keqi.seed.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.seed.sys.domain.db.MenuDO;
import com.keqi.seed.sys.domain.vo.MenuVO;

import java.util.List;

public interface MenuMapper extends BaseMapper<MenuDO> {

	List<MenuVO> selectByAccountId(Long accountId);
}