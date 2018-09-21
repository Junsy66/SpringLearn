package com.junsy.spring.ioc.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 功能描述:
 *
 * @author: YinShiJun
 * @date: 2018/9/20
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public interface Resource {

    /**
     * 获取资源流
     * @return
     */
    InputStream getInoutStream()  throws IOException;

}
