package com.junsy.spring.ioc;

/**
 * 功能描述:用戶描述Bean的属性
 *
 * @author: YinShiJun
 * @date: 2018/9/20
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public class PropertyValue {

    /**
     * 属性名称 final 初始化后不可改变
     */
    private final  String name;

    /**
     * 属性值 final
     */
    private final  Object value;

    /**
     * 构造函数初始化属性
     * @param name
     * @param value
     */
    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
