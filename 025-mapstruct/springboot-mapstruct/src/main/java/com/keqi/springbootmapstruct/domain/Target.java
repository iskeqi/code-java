package com.keqi.springbootmapstruct.domain;

public class Target {

	private String id;

	private Integer num;

	private Integer count;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Target{" +
				"id='" + id + '\'' +
				", num=" + num +
				", count=" + count +
				'}';
	}
}
