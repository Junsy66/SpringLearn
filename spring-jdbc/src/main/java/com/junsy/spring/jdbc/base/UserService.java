package com.junsy.spring.jdbc.base;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Types;

/**
 * 功能描述:
 *
 * @author: YinShiJun
 * @date: 2018/9/26
 * @version:1.0.0
 * @Copyright (c) 深圳市牛鼎丰科技有限公司-版权所有
 */
public class UserService implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addUser(User user) {
        jdbcTemplate.update("insert INTO t_user(user_id,user_name,user_sex) VALUES (?,?,?)",
                new Object[]{user.getUserId(), user.getUserName(), user.getUserSex()},
                new int[]{Types.BIGINT, Types.VARCHAR, Types.INTEGER});
    }

    @Override
    public User queryUser(Long userId) {
        return null;
    }
}
