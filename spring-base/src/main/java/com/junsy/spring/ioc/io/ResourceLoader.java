package com.junsy.spring.ioc.io;

import java.net.URL;

/**
 * 功能描述:加载Resource
 *
 * @author: YinShiJun
 * @date: 2018/9/20
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public class ResourceLoader {

    /**
     * 返回资源信息
     * @param location 资源路径
     * @return
     */
    public Resource getResource(String location) {
        URL url = this.getClass().getClassLoader().getResource(location);
        return new URLResource(url);
    }

}
