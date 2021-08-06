package com.keqi.seed.sys.domain.param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.seed.sys.domain.db.RoleDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RolePageParam extends Page<RoleDO> {

    private String name;

    private String permiss;
}
