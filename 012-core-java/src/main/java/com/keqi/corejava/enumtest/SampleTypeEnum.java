package com.keqi.corejava.enumtest;

public enum SampleTypeEnum implements IEnum {

	/**
	 * 所有设备
	 */
	ALL("所有设备"),

	/**
	 * 指定设备
	 */
	FIXED("指定设备"),

	/**
	 * RANDOM随机设备
	 */
	RANDOM("随机设备");


	private final String msg;

	SampleTypeEnum(String msg) {
		this.msg = msg;
	}

	@Override
	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
