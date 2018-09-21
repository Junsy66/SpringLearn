package com.junsy.spring.ioc;

/**
 * 功能描述:定义BeanDefinition
 * 对应 xml 中 bean  及 实例信息
 *
 * @author: YinShiJun
 * @date: 2018/9/20
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public class BeanDefinition {

    /**
     * 实例Bean对象
     */
    private Object bean;

    /**
     * 对应bean的类名称
     */
    private String beanClassName;

    /**
     * 对应Bean的类对象
     */
    private Class beanClass;


    /**
     * bean属性
     */
    private PropertyValues propertyValues = new PropertyValues();


    public BeanDefinition() {

    }


    /**
     * bean赋值
     */
    public void setBean(Object bean) {
        this.bean = bean ;
    }


    /**
     * 获取Bean
     * @return
     */
    public Object getBean() {
        return bean;
    }

    public String getBeanClassName() {
        return beanClassName;
    }

    /**
     * 类名称
     * @param beanClassName
     */
    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        // 根据类名称，通过Java的反射机制生成类Class对象，并赋值
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
