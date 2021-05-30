package com.keqi.hutool.core;

import cn.hutool.core.util.ZipUtil;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipInputStream;

/**
 * @author keqi
 */
public class ZipFileTest {
	
	@Test
	public void test1() throws IOException {
		// 在编写 Java 代码时，有时候会需要对文件进行压缩和解压缩
		// JDK 中提供了 ZipInputStream/GZIPInputStream 来进行操作
		// 但是直接使用原生的API过于繁琐，实际编码过程中可以使用 ZipUtil 工具类来解决
		ZipInputStream zipInputStream;
		GZIPInputStream gzipInputStream;
		
		// 查看源代码发现，其实人家就是用的 JDK 中内置的 ZipOutputStream 类实现的
		File zip = ZipUtil.zip("D:\\KEQI\\MyCode\\code-java\\008-hutool\\hutool-core\\userMap.xml");
		System.out.println(zip.getCanonicalFile());
	}
}
