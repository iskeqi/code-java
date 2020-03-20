package com.keqi.springbootmybatisognl.common;

/**
 * 分页实体参数类
 */
public class PageParam {

	/**
	 * 当前页数
	 */
	protected int pageNum = 1;

	/**
	 * 每页大小
	 */
	protected int pageSize = 10;

	/**
	 * 计算偏移量(使用方式：LIMIT #{offset}, #{pageSize})
	 *
	 * @return 偏移量
	 */
	public int getOffset() {
		// pageSize <= 0 时，即查询所有记录
		return this.getPageSize() * (this.getPageNum() - 1);
	}

	public int getPageNum() {
		return pageNum <= 0 ? 1 : pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
