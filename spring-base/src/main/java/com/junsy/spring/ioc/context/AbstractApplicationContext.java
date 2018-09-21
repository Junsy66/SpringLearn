package com.junsy.spring.ioc.context;


import com.junsy.spring.ioc.factory.AbstractBeanFactory;

/**
 * 功能描述:
 *
 * @author: YinShiJun
 * @date: 2018/9/21
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public abstract class  AbstractApplicationContext implements  ApplicationContext {

    protected AbstractBeanFactory beanFactory;

    public AbstractApplicationContext(AbstractBeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public Object getBean(String name) throws Exception {
        return beanFactory.getBean(name);
    }

    /**
     * 加载注册方法
     * @throws Exception
     */
    public void refrech() throws  Exception {

    }
}
