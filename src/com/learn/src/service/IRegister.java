package com.learn.src.service;

import com.learn.src.dao.User;

public interface IRegister {
    /**
     *
     * @param user 用户
     * @return 返回是否注册成功
     */
    public boolean RegisterToDatabase(User user);
}
