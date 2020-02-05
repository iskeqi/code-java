package com.keqi.springbootupload.util;

/**
 * 解压缩工具类
 * @author keqi
 */
import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;

import java.io.File;

public class ZipUtil {

	/**
	 * 解压zip格式压缩包
	 * 对应的是ant.jar
	 */
	private static void unzip(String sourceZip, String destDir) throws Exception {
		try {
			Project p = new Project();
			Expand e = new Expand();
			e.setProject(p);
			e.setSrc(new File(sourceZip));
			e.setOverwrite(false);
			e.setDest(new File(destDir));
           /*
           ant下的zip工具默认压缩编码为UTF-8编码，
           而winRAR软件压缩是用的windows默认的GBK或者GB2312编码
           所以解压缩时要制定编码格式
           */

			// 如果人家就是用utf-8进行编码的呢？
			e.setEncoding("gbk");
			e.execute();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}



	/**
	 * 根据压缩包文件后缀选择采用哪种方式进行解压
	 * @param sourceFile 压缩包源文件路径
	 * @param destDir 压缩包解压后的文件存储路径
	 * @throws Exception
	 */
	private static void unfile(String sourceFile, String destDir) throws Exception {
		// 根据类型，进行相应的解压缩(目前只支持zip格式，以后需要可以添加其他方式)
		String type = sourceFile.substring(sourceFile.lastIndexOf(".") + 1);
		if (type.toLowerCase().equals("zip")) {
			ZipUtil.unzip(sourceFile, destDir);
		} else {
			System.out.println(type.toLowerCase());
			throw new RuntimeException("deCompress: 只支持zip格式的压缩包！");
		}
	}

	/**
	 * 根据压缩包文件后缀选择采用哪种方式进行解压
	 * @param sourceFile 压缩包源文件路径
	 * @param destDir 压缩包解压后的文件存储路径
	 * @throws Exception
	 */
	private static void deCompress(String sourceFile, String destDir) throws Exception {
		if (sourceFile == null || destDir == null) {
			throw new RuntimeException("deCompress: 目录不能为空");
		}
		// 保证文件夹路径最后是"/"或者"\"
		char lastChar = destDir.charAt(destDir.length() - 1);
		if (lastChar != '/' && lastChar != '\\') {
			destDir += File.separator;
		}
		unfile(sourceFile, destDir);
	}

	/**
	 * 解压压缩包文件到指定的目录中去
	 * @param sourceFile 压缩包所在的路径
	 * @param destDir 解压后的文件存储所在目录
	 * @throws Exception
	 */
	public static void deCompress(File sourceFile, File destDir) throws Exception {
		if (!sourceFile.exists() || sourceFile.isDirectory()) {
			throw new RuntimeException("deCompress: 文件不存在");
		}
		if (!destDir.isDirectory()) {
			throw new RuntimeException("deCompress: destDir必须是一个目录");
		}
		deCompress(sourceFile.getPath(), destDir.getPath());
	}

	/**
	 * 使用示例(需要运行时把private改成publish即可)
	 * @param args args
	 * @throws Exception exception
	 */
	public static void main(String[] args) throws Exception {
		File sourceFile = new File("D:/data/image/image.zip");
		File destDir = new File("D:/data/picture/1575512966679c3b79cc8-4bf0-4e85-959b-6593c4df4142");
		ZipUtil.deCompress(sourceFile,destDir);
	}
}
