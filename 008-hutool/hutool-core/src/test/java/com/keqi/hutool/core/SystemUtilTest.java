package com.keqi.hutool.core;

import cn.hutool.system.JvmInfo;
import cn.hutool.system.OsInfo;
import cn.hutool.system.SystemUtil;
import org.junit.Test;

/**
 * 测试cn.hutool.system.SystemUtil类的相关API
 */
public class SystemUtilTest {

	@Test
	public void rangeToList() {
		// 获取当前进程ID
		long currentPID = SystemUtil.getCurrentPID();
		// 获取最大内存
		long maxMemory = SystemUtil.getMaxMemory();
		// 获取os信息
		OsInfo osInfo = SystemUtil.getOsInfo();
		System.out.println(osInfo);
		// 获取jvm信息
		JvmInfo jvmInfo = SystemUtil.getJvmInfo();
		System.out.println(jvmInfo);
	}
}
