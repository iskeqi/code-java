package com.atguigu.spring5.service;

import com.atguigu.spring5.dao.UserDao;

public class UserService {


    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add() {
        System.out.println("service add ....");


        userDao.update();
    }
}
