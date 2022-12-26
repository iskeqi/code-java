package com.keqi.springbootmvcsource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (BeanLifeCycle.class == bean.getClass()) {
            log.info("{} - {},{}", CountUtil.count.incrementAndGet(), "BeanPostProcessor.postProcessBeforeInitialization", beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (BeanLifeCycle.class == bean.getClass()) {
            log.info("{} - {},{}", CountUtil.count.incrementAndGet(), "BeanPostProcessor.postProcessAfterInitialization", beanName);
        }
        return bean;
    }
}
