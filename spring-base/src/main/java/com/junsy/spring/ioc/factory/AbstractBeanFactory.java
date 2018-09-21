package com.junsy.spring.ioc.factory;

import com.junsy.spring.ioc.BeanDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能描述:
 *
 * @author: YinShiJun
 * @date: 2018/9/20
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public abstract class AbstractBeanFactory implements BeanFactory {

    /**
     * 定义了BeanDefinition容器
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    /**
     * 所有实例名称
     */
    private final List<String> beanDefinitionNames = new ArrayList<>();


    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception {
        // 注册Bean
        beanDefinitionMap.put(name, beanDefinition);
        beanDefinitionNames.add(name);
    }

    /**
     * 在加载后，完成所有Bean的实例化操作
     * @throws Exception
     */
    public void preInstantiateSingletons() throws  Exception{
        Iterator<String> iterator = beanDefinitionNames.iterator();
        while (iterator.hasNext()) {
            getBean(iterator.next());
        }
    }

    @Override
    public Object getBean(String name) throws  Exception {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {
            throw new IllegalArgumentException("beanDefintion is null");
        }
        Object bean = beanDefinition.getBean();
        if (bean == null) {
            // 若 bean 为空, 创建 bean
            bean = doCreateBean(beanDefinition);
        }
        return bean;
    }



    /**
     * 创建BeanDefinition
     * 通过容器来管理bean的创建
     * @param beanDefinition
     * @return
     */
    protected abstract Object doCreateBean(BeanDefinition beanDefinition) throws Exception;
}
