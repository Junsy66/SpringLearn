package com.junsy.spring.jdbc.base;

/**
 * 功能描述:
 *
 * @author: YinShiJun
 * @date: 2018/9/26
 * @version:1.0.0
 * @Copyright (c) 深圳市牛鼎丰科技有限公司-版权所有
 */
public interface UserDao {

    void addUser(User user);

    User queryUser(Long userId);

}
