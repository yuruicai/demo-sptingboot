package com.yuruicai.test.eureakserver;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component
public class TestBeanNameAware implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.out.println("TestNameAware ---test "+s);
    }
}
