package com.keqi.apihu.manage.domain.param;

import com.keqi.apihu.core.common.QueryBaseParam;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListMyProjectParam extends QueryBaseParam {

	/**
	 * 当前登录用户id
	 */
	private Long accountId;
}
