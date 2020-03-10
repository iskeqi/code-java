package com.keqi.corejava.enumtest;

/**
 * 枚举也是一种类型，和枚举中的元素就是这个枚举类型的对象，这没有任何不同
 */
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


	private final String valueName;

	SampleTypeEnum(String valueName) {
		this.valueName = valueName;
	}

	@Override
	public String getValueName() {
		return valueName;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
