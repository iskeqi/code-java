package com.keqi.apihu.sys.domain.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户-项目关联表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountProjectDO {
    /**
     * 用户ID
     */
    private Long accountId;

    /**
     * 项目ID
     */
    private Long projectId;
}