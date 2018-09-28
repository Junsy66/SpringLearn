package com.junsy.spring.jdbc.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 功能描述: jdbcTemplate 基础数据库操作
 *
 * @author: YinShiJun
 * @date: 2018/9/26
 * @version:1.0.0
 * @Copyright (c) 深圳市牛鼎丰科技有限公司-版权所有
 */
public class UserServiceTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-jdbc-base.xml");
        UserDao userDao = (UserService) context.getBean("userService");
        User user = new User();
        user.setUserId(739666L);
        user.setUserName("Junsy");
        user.setUserSex(1);
        userDao.addUser(user);
    }
}
