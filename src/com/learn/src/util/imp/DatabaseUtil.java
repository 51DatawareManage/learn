package com.learn.src.util.imp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.learn.src.util.IDatabaseUtil;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class DatabaseUtil implements IDatabaseUtil {
    private String   databaseinfo="/learn/resource/databaseinfo.json";
    private Logger logger=new Logger();
    public Connection conn=null;
    public JSONObject getDatabaseInfo(String db) {
        JSONObject json=null;
        try{
            FileReader file=new FileReader(new File(databaseinfo));
            BufferedReader inputStream = new BufferedReader(file);
            String str="";
            String databaseinfo="";
            while ((str = inputStream.readLine()) != null) {
                databaseinfo=databaseinfo.concat(str);
            }
            json= JSON.parseObject(JSON.parseObject(databaseinfo).get(db).toString());
        } catch (FileNotFoundException e) {
            logger.saveLogger("数据库信息加载异常，具体原因如下",e.getStackTrace().toString());
        } catch (IOException e) {
            logger.saveLogger("数据库信息读取失败，具体原因如下",e.getStackTrace().toString());
        }
    return json;
    }


    public void getDatabase(String db) {
        JSONObject json=getDatabaseInfo(db);
        Connection conn=null;
        try{
            Class.forName(json.getString("driver"));
            conn=DriverManager.getConnection(json.getString("url"),json.getString("username"),json.getString("password"));
        } catch (ClassNotFoundException e) {
            logger.saveLogger("数据库驱动获取失败",e.getStackTrace().toString());
        } catch (SQLException e) {
            logger.saveLogger("数据库连接获取失败",e.getStackTrace().toString());
        }
        this.conn=conn;
    }
    public void changeDB(String db) {
       getDatabase(db);
    }


    public ResultSet query(String sql) {
        return null;
    }

    public boolean excute(String sql) {
        return false;
    }

    public boolean insert(String sql) {
        return false;
    }

    public boolean update(String sql) {
        return false;
    }

    public boolean delete(String sql) {
        return false;
    }
}
