package com.keqi.projectseedsecond.common;

/**
 * 分页实体参数类（仅用于规范命名，不要求必须继承，可以拷贝需要的属性至自己的Param实体类中）
 */
public class PageParam {

	/**
	 * 当前页数（最小为1）
	 */
	protected int pageNum = 1;

	/**
	 * 每页大小（最大为50）
	 */
	protected int pageSize = 10;

	/**
	 * 计算偏移量(使用方式：
	 *
	 * <if test="pageSize >= 0">
	 *    LIMIT #{offset}, #{pageSize})
	 * </if>
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
		return Math.min(pageSize, 50);
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
