package com.keqi.seed.sys.domain.param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.keqi.seed.sys.domain.db.AccountDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountPageParam extends Page<AccountDO> {

    private String post;
}
