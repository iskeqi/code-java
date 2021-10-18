package com.keqi.seed.sys.domain.param;

import com.keqi.seed.core.pojo.QueryBaseParam;
import com.keqi.seed.sys.domain.db.AccountDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class AccountPageParam extends QueryBaseParam<AccountDO> {

    @ApiModelProperty("岗位")
    private String post;
}
