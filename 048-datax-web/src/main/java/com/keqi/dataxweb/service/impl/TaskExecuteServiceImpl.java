package com.keqi.dataxweb.service.impl;

import com.keqi.dataxweb.service.TaskExcuteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

@Slf4j
@Service
public class TaskExecuteServiceImpl implements TaskExcuteService {

	// 参考链接：https://my.oschina.net/u/3625378/blog/1789462 https://blog.nowcoder.net/n/cee796627f7a4336886bf6655056e693

	@Override
	public Map<String, Object> executeTask(Integer taskId) {
		Map<String, Object> r = new HashMap<>();

		String osName = System.getProperties().getProperty("os.name");

		if (!"Linux".equals(osName)) {
			throw new RuntimeException("当前操作仅支持在 Linux 操作系统中运行");
		}

		String command = null;
		if (taskId == 1) {
			command = "python /home/keqi/datax-study/datax/bin/datax.py /home/keqi/datax-study/datax/job/task_1_MySQLToMySQL.json";
		}
		if (taskId == 2) {
			command = "python /home/keqi/datax-study/datax/bin/datax.py /home/keqi/datax-study/datax/job/task_2_MySQLToMySQL.json";
		}

		Process process = null;
		try {
			r.put("开始执行命令的时间是", LocalDateTime.now());
			process = Runtime.getRuntime().exec(command);
			r.put("命令执行结束的时间是", LocalDateTime.now());

			StringJoiner successResult = new StringJoiner("\n");
			Process successProcess = process;
			Thread successThread = new Thread(() -> {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(successProcess.getInputStream()));
				try {
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						successResult.add(line);
					}
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				} finally {
					try {
						bufferedReader.close();
					} catch (IOException e) {
						log.error(e.getMessage(), e);
					}
				}
			});
			successThread.start();

			StringJoiner errorResult = new StringJoiner("\n");
			Process errorProcess = process;
			Thread failureThread = new Thread(() -> {
				BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorProcess.getErrorStream()));
				try {
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						errorResult.add(line);
					}
				} catch (IOException e) {
					log.error(e.getMessage(), e);
				} finally {
					try {
						bufferedReader.close();
					} catch (IOException e) {
						log.error(e.getMessage(), e);
					}
				}
			});
			failureThread.start();

			r.put("开始执行process.waitFor()命令的时间是", LocalDateTime.now());
			int resultCode = process.waitFor();
			r.put("执行process.waitFor()命令后的时间是", LocalDateTime.now());
			if (resultCode == 0) {
				log.info("=====================成功=====================");
				log.info(successResult.toString());
				// 这里的日志应该单独使用一个 .log 文件存储，以便后续查看
				// 或者干脆复用 datax 的日志文件信息（最佳方案）
			} else {
				log.info("=====================失败=====================");
				log.info(errorResult.toString());
			}


		} catch (IOException | InterruptedException e) {
			log.error(e.getMessage(), e);
		} finally {
			process.destroy();
		}

		return r;
	}
}
