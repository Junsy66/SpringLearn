package com.junsy.spring.ioc.io;



import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 功能描述:
 *
 * @author: YinShiJun
 * @date: 2018/9/20
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public class URLResource implements  Resource{

    private URL url;

    public URLResource(URL url) {
        this.url = url;
    }

    @Override
    public InputStream getInoutStream() throws  IOException{
        URLConnection connection = url.openConnection();
        return connection.getInputStream();
    }
}
