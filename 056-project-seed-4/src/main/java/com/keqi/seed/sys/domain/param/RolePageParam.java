package com.keqi.seed.sys.domain.param;

import com.keqi.seed.core.pojo.QueryBaseParam;
import com.keqi.seed.sys.domain.db.RoleDO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RolePageParam extends QueryBaseParam<RoleDO> {

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("权限表示")
    private String permiss;
}
