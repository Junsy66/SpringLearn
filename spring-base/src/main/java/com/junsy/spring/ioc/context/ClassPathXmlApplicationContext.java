package com.junsy.spring.ioc.context;

import com.junsy.spring.ioc.BeanDefinition;
import com.junsy.spring.ioc.factory.AbstractBeanFactory;
import com.junsy.spring.ioc.factory.AutowireCapableBeanFactory;
import com.junsy.spring.ioc.io.ResourceLoader;
import com.junsy.spring.ioc.reader.XmlBeanDefinitionReader;
import java.util.Map;

/**
 * 功能描述:
 *
 * @author: YinShiJun
 * @date: 2018/9/21
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public class ClassPathXmlApplicationContext  extends  AbstractApplicationContext{

    private String cofigLocation;

    public ClassPathXmlApplicationContext(String cofigLocation)  throws  Exception{
        this(cofigLocation, new AutowireCapableBeanFactory());
    }

    public ClassPathXmlApplicationContext(String cofigLocation, AbstractBeanFactory beanFactory) throws  Exception {
        super(beanFactory);
        this.cofigLocation = cofigLocation;
        refrech();

    }

    @Override
    public void refrech() throws  Exception{

        // 完成资源数据的读取 和 bean 的注册
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions(cofigLocation);
        Map<String,BeanDefinition> beanDefinitions = xmlBeanDefinitionReader.getRegistry();
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitions.entrySet()) {
            beanFactory.registerBeanDefinition(entry.getKey(),entry.getValue());
        }
    }


}
