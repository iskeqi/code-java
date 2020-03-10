package com.keqi.corejava.enumtest;

/**
 * 数据源(数据源枚举类，枚举类即使不指定属性，也是可以直接用的，
 * 就相当于是一个字符串属性，只是不用显示的写出来了
 * )
 *
 * @author ruoyi
 */
public enum DataSourceTypeEnum {

	/**
	 * 主库
	 */
	MASTER,

	/**
	 * 从库
	 */
	SLAVE

}

