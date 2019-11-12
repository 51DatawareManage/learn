package com.learn.src.service.imp;

import com.learn.src.dao.User;
import com.learn.src.service.IRegister;
import com.learn.src.service.IToDatabase;
import com.learn.src.util.imp.DatabaseUtil;

import java.util.Map;

public class Register implements  IToDatabase<User> {
    User user=null;
    public Register(Map<String,String> map){
        user= new User(map);
    }

    public boolean saveToDatabase(User user) {
        DatabaseUtil util=new DatabaseUtil("yangyunxia");

        return false;
    }
}
