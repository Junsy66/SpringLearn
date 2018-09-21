package com.junsy.spring.ioc.factory;

import com.junsy.spring.ioc.BeanDefinition;
import com.junsy.spring.ioc.BeanReference;
import com.junsy.spring.ioc.PropertyValue;
import java.lang.reflect.Field;

/**
 * 功能描述:自动装配
 * 实现了Bean对象的自动生成以及注入
 *
 * @author: YinShiJun
 * @date: 2018/9/20
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        // 对象属性赋值,否则会导致 StackOverflowError
        beanDefinition.setBean(bean);
        applyPropertyValues(bean,beanDefinition);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws  Exception{

        return  beanDefinition.getBeanClass().newInstance();
    }


    /**
     * 实例对象属性赋值
     * @param bean
     * @param beanDefinition
     */
    protected void applyPropertyValues( Object bean,BeanDefinition beanDefinition) throws  Exception {

        // 属性赋值
        for (PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()) {
            Field filed = bean.getClass().getDeclaredField(propertyValue.getName());
            filed.setAccessible(true);
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                // 若 value 为 关联对象，value 值为 关联的 bean 的 id 值
                BeanReference reference = (BeanReference) value;
                value = getBean(((BeanReference) value).getName());
            }
            filed.set(bean, value);
        }
    }


}
