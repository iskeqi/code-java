package com.keqi.springbootmvcsource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class BeanLifeCycle implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private CountUtil countUtil;

    public BeanLifeCycle() {
        log.info("{} - {}", CountUtil.count.incrementAndGet(), "constructor");
    }

    public CountUtil getCountUtil() {
        return countUtil;
    }

    @Autowired
    public void setCountUtil(CountUtil countUtil) {
        this.countUtil = countUtil;
        log.info("{} - {}", countUtil.getCount().incrementAndGet(), "setter method");
    }

    @PostConstruct
    public void postConstruct() {
        log.info("{} - {}", countUtil.getCount().incrementAndGet(), "@PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("{} - {}", countUtil.getCount().incrementAndGet(), "@PreDestroy");
    }


    @Override
    public void setBeanName(String s) {
        log.info("{} - {},{}", countUtil.getCount().incrementAndGet(), "BeanNameAware.setBeanName", s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("{} - {},{}", countUtil.getCount().incrementAndGet(), "BeanFactoryAware.setBeanFactory", beanFactory.getClass().getCanonicalName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("{} - {},{}", countUtil.getCount().incrementAndGet(), "ApplicationContextAware.setApplicationContext", applicationContext.getClass().getCanonicalName());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("{} - {}", countUtil.getCount().incrementAndGet(), "InitializingBean.afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        log.info("{} - {}", countUtil.getCount().incrementAndGet(), "DisposableBean.destroy");
    }
}
