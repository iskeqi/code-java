package com.keqi.webexecutor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
public class DemoController {

	@GetMapping("/test")
	public String test() {
		// 如果这个时候程序正常关闭了，那么这个定时任务还是会继续执行的。
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					double random = Math.random();
					Files.createFile(Paths.get("D:\\test\\" + random + ".txt"));
					System.out.println("random");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, 1000L, 500L);
		return "success";
	}
}
