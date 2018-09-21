package com.junsy.spring.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:封装了属性列表以及相关操作
 *
 * @author: YinShiJun
 * @date: 2018/9/20
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public class PropertyValues {

    /**
     * 属性列表
     */
    private final List<PropertyValue> propertyValueList = new ArrayList<>();


    /**
     * 添加属性值
     *
     * @param propertyValue
     */
    public void addPropertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }


    /**
     * 获取属性列表
     * @return
     */
    public List<PropertyValue> getPropertyValues() {
        return  this.propertyValueList;
    }


}
