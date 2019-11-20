package com.learn.src.controller;

import com.learn.src.util.imp.DatabaseUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

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
