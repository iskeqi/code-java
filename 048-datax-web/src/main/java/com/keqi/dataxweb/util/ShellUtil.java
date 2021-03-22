package com.keqi.dataxweb.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellUtil {

	public static String execShell(String shell) {
		StringBuilder result = new StringBuilder();
		Process process = null;
		BufferedReader bufferedReaderInfo = null;
		BufferedReader bufferedReaderError = null;
		try {
			// 执行shell命令，返回了一个进程
			process = Runtime.getRuntime().exec(shell);
			// 等待命令执行完成
			process.waitFor();
			// 获取结果，正常返回是第一个，错误返回是第二个，返回结果只能有一个，要么正常执行，要么执行错误
			bufferedReaderInfo = new BufferedReader(new InputStreamReader(process.getInputStream()));
			bufferedReaderError = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			String line;
			// 将返回结果存到一个stringbuilder里面，因为StringBuilder是可扩展的，所以不用String
			while (bufferedReaderInfo.readLine() != null || bufferedReaderError.readLine() != null) {
				if (bufferedReaderInfo.readLine() != null) {
					line = bufferedReaderInfo.readLine();
				} else {
					line = bufferedReaderError.readLine();
				}
				result.append(line).append("\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			// 释放资源
			if (bufferedReaderError!=null){
				try {
					bufferedReaderError.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bufferedReaderInfo!=null){
				try {
					bufferedReaderInfo.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (process!=null){
				process.destroy();
			}

		}
		return result.toString();
	}

}
