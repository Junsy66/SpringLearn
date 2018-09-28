package com.junsy.spring.jdbc.base;

/**
 * 功能描述:
 *
 * @author: YinShiJun
 * @date: 2018/9/26
 * @version:1.0.0
 * @Copyright (c) 深圳市牛鼎丰科技有限公司-版权所有
 */
public class User {

    private Long userId;
    private String userName;
    private int userSex;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserSex() {
        return userSex;
    }

    public void setUserSex(int userSex) {
        this.userSex = userSex;
    }
}
