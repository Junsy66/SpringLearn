package com.junsy.spring.ioc;

import com.junsy.spring.ioc.context.ApplicationContext;
import com.junsy.spring.ioc.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * 功能描述:
 *
 * @author: YinShiJun
 * @date: 2018/9/21
 * @version:1.0.0
 * @Copyright (c) 深圳市爱桔iorange科技有限公司-版权所有
 */


public class iocApplicationContextTest {

    @Test
    public void test() throws  Exception{

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-ioc.xml");
        HelloService helloService = (HelloService) context.getBean("helloService");
        helloService.hello();
        //
        HelloMinaService minaService = (HelloMinaService) context.getBean("minaService");
        minaService.hi();

    }
}
