package com.keqi.springbootmvcsource;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        log.info("{} - {},{}", CountUtil.count.incrementAndGet(), "BeanFactoryPostProcessor.postProcessBeanFactory",
                configurableListableBeanFactory.getClass().getCanonicalName());
    }
}
