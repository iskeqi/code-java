//package com.keqi.tlog;
//
//import com.yomahub.tlog.core.annotation.TLogAspect;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.util.UUID;
//
//@Slf4j
//@Component
//@EnableScheduling
//public class SpringJob {
//
//	//@Scheduled(fixedRate = 100)
//	public void init() {
//		log.info("==========");
//		demo1(UUID.randomUUID().toString());
//	}
//
//	@TLogAspect({"id"})
//	public void demo1(String id) {
//		log.info(UUID.randomUUID().toString());
//	}
//}
