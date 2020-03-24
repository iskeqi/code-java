package com.keqi.springbootmapstruct.domain;

public class Source {

	private String id;

	private Integer numSource;

	private Integer totalCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNumSource() {
		return numSource;
	}

	public void setNumSource(Integer numSource) {
		this.numSource = numSource;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "Source{" +
				"id='" + id + '\'' +
				", numSource=" + numSource +
				", totalCount=" + totalCount +
				'}';
	}
}
