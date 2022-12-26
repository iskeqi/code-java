package com.keqi.springbootmvcsource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (BeanLifeCycle.class == beanClass) {
            log.info("{} - {},{}", CountUtil.count.incrementAndGet(), "InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation", beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (BeanLifeCycle.class == bean.getClass()) {
            log.info("{} - {},{}", CountUtil.count.incrementAndGet(), "InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation", beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessAfterInstantiation(bean, beanName);
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        if (BeanLifeCycle.class == bean.getClass()) {
            log.info("{} - {},{}", CountUtil.count.incrementAndGet(), "InstantiationAwareBeanPostProcessor.postProcessProperties", beanName);
        }
        return InstantiationAwareBeanPostProcessor.super.postProcessProperties(pvs, bean, beanName);
    }
}
