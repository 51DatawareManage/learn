package com.learn.src.service.imp;

import com.learn.src.dao.imp.User;

import java.util.HashMap;
import java.util.Map;

public  class Register {
    public static boolean doRegister(Map<String,String> map){
        User user= new User(map);
       return new DataToDatabse(user).saveToDatabase();
    }
}
