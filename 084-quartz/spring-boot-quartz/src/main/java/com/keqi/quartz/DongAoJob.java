package com.keqi.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;

@Slf4j
public class DongAoJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("{} 幼年是盼盼，青年是晶晶，中年是冰墩墩，生活见好逐渐发福", LocalDateTime.now());
    }
}
