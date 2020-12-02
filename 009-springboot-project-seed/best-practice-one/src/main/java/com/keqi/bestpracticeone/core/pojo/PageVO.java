package com.keqi.bestpracticeone.core.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 分页响应VO（命名和 MyBatisPlus 保持一致）
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVO<T> {

    private int total;

    private List<T> records;
}
