package com.keqi.apihu.manage.domain.param;

import com.keqi.apihu.core.common.QueryBaseParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 项目列表查询接口参数
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
public class ProjectListParam extends QueryBaseParam {

}
