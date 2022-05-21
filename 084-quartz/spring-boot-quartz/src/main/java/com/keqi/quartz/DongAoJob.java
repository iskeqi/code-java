package com.keqi.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

@Slf4j
//@PersistJobDataAfterExecution
public class DongAoJob extends QuartzJobBean {

    // 每次执行时，都会创建一个新的对象来使用

    /*
        无状态Job:多次调用Job时，每次都是创建一个新的
        有状态Job：多次调用Job时，都会对Job对象进行持久化，需要再类上加注解@PersistJobDataAfterExecution
     */




// https://cloud.tencent.com/developer/article/1947192
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//        log.info("{} 幼年是盼盼，青年是晶晶，中年是冰墩墩，生活见好逐渐发福", LocalDateTime.now());
//        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
//        log.info(mergedJobDataMap.toString());
        log.info(this.toString());
    }
}
