package com.junsy.spring.ioc.factory;

import com.junsy.spring.ioc.BeanDefinition;

/**
 * 功能描述:Bean生成工厂
 *
 * @author: YinShiJun
 * @date: 2018/9/20
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public interface BeanFactory {


    /**
     * 获取Bean，实例化Bean对象
     * @param name
     * @return
     */
    Object getBean(String name) throws Exception;


}
