package com.junsy.spring.ioc;

/**
 * 功能描述:
 *
 * @author: YinShiJun
 * @date: 2018/9/21
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */
public class HelloMinaService {

    private HelloService helloService;

    public void sayHello() {
        System.out.println(" Hello world !!!");
    }

    public void hi() {
        helloService.hi();
    }



}
