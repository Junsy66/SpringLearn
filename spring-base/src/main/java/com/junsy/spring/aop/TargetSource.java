package com.junsy.spring.aop;

/**
 * 功能描述:被代理对象
 *
 * @author: YinShiJun
 * @date: 2018/9/25
 * @version:1.0.0
 * @Copyright (c) 深圳市牛鼎丰科技有限公司-版权所有
 */
public class TargetSource {

    private Class targetClass;
    private Object target;

    /**
     * 构造函数初始化
     * @param targetClass
     * @param target
     */
    public TargetSource(Class targetClass, Object target) {
        this.targetClass = targetClass;
        this.target = target;
    }

    public Class getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }
}
