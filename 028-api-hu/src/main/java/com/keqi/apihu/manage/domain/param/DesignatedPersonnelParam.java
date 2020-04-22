package com.keqi.apihu.manage.domain.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DesignatedPersonnelParam {

	private Long projectId;
	private List<Long> accountIdList;

}
