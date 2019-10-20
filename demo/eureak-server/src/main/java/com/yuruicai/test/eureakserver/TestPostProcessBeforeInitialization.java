package com.yuruicai.test.eureakserver;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//@Component
public class TestPostProcessBeforeInitialization implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("bean 初始化前处理 bean = "+o.toString());
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("bean 初始化后处理 = "+o.toString());
        return o;
    }
}
