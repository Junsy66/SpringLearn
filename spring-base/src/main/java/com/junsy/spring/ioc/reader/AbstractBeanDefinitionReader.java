package com.junsy.spring.ioc.reader;

import com.junsy.spring.ioc.BeanDefinition;
import com.junsy.spring.ioc.factory.AbstractBeanFactory;
import com.junsy.spring.ioc.io.ResourceLoader;
import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:
 * 抽象类，定义常量
 *
 * @author: YinShiJun
 * @date: 2018/9/20
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    /**
     * 记录表
     */
    private Map<String, BeanDefinition> registry;

    /**
     * 资源加载器
     */
    private ResourceLoader resourceLoader;


    protected AbstractBeanDefinitionReader( ResourceLoader resourceLoader) {
        this.registry = new HashMap<String,BeanDefinition>();
        this.resourceLoader = resourceLoader;
    }

    public Map<String, BeanDefinition> getRegistry() {
        return registry;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
