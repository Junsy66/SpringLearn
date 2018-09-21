package com.junsy.spring.ioc.reader;

import java.io.IOException;

/**
 * 功能描述:
 *
 * @author: YinShiJun
 * @date: 2018/9/20
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws IOException, Exception;

}
