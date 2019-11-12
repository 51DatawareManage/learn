package com.learn.src.controller;

import com.learn.src.dao.User;
import com.learn.src.util.imp.DatabaseUtil;
import com.learn.src.util.imp.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class LearnController {
    public static void main(String[] args){
        DatabaseUtil logger=new DatabaseUtil("yangyunxia");
        ResultSet query = logger.query("select * from test");
        try {
            while (query.next()){
            System.out.println(query.getString("t2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
