package com.learn.src.util.imp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.learn.src.util.IDatabaseUtil;

import java.io.*;
import java.sql.*;
import java.util.Arrays;

public class DatabaseUtil implements IDatabaseUtil {
    private final String  databaseinfo="../datas/databaseinfo.json";
    private Logger logger=new Logger();
    private Connection conn=null;
    private Statement pstm=null;
    public JSONObject getDatabaseInfo(String db) {
        JSONObject json=null;
        try{
            FileReader file=new FileReader(new File(databaseinfo));
            BufferedReader inputStream = new BufferedReader(file);
            String str;
            String databaseinfo="";
            while ((str = inputStream.readLine()) != null) {
                databaseinfo=databaseinfo.concat(str);
            }
            json= JSON.parseObject(JSON.parseObject(databaseinfo).get(db).toString());
        } catch (FileNotFoundException e) {
            logger.saveLogger("数据库信息加载异常，具体原因如下", Arrays.toString(e.getStackTrace()));
        } catch (IOException e) {
            logger.saveLogger("数据库信息读取失败，具体原因如下", Arrays.toString(e.getStackTrace()));
        }
    return json;
    }


    public  DatabaseUtil(String db) {
        JSONObject json=getDatabaseInfo(db);
        System.out.println(json);
        Connection conn;
        try{
            Class.forName(json.getString("driver"));
            conn=DriverManager.getConnection(json.getString("url"),json.getString("username"),json.getString("password"));
            this.conn=conn;
            this.pstm=conn.createStatement();
        } catch (ClassNotFoundException e) {
            logger.saveLogger("数据库驱动获取失败", Arrays.toString(e.getStackTrace()));
        } catch (SQLException e) {
            logger.saveLogger("数据库连接获取失败", Arrays.toString(e.getStackTrace()));
        }

    }
    public void changeDB(String db) {
        new DatabaseUtil(db);
    }

    public ResultSet query(String sql) {
        ResultSet rs=null;
        try {
            rs=pstm.executeQuery(sql);
        } catch (SQLException e) {
            logger.saveLogger("数据库数据查询失败", Arrays.toString(e.getStackTrace()));
        }
        return rs;
    }

    public boolean excute(String sql) {
        boolean rs=false;
        try {
            rs=pstm.execute(sql);
        } catch (SQLException e) {
            logger.saveLogger("数据库sql执行失败", Arrays.toString(e.getStackTrace()));
        }
        return rs;
    }

    public boolean insert(String sql) {
        boolean rs=false;
        try {
            rs=pstm.execute(sql);
        } catch (SQLException e) {
            logger.saveLogger("数据库sql插入失败", Arrays.toString(e.getStackTrace()));
        }
        return rs;
    }

    public boolean update(String sql) {
        boolean rs=false;
        try {
            int s=pstm.executeUpdate(sql);
            if(s>0){
                rs=true;
            }
        } catch (SQLException e) {
            logger.saveLogger("数据库sql更新失败", Arrays.toString(e.getStackTrace()));
        }
        return rs;
    }

    public boolean delete(String sql) {
        boolean rs=false;
        try {
            rs=pstm.execute(sql);
        } catch (SQLException e) {
            logger.saveLogger("数据库sql执行失败", Arrays.toString(e.getStackTrace()));
        }
        return rs;
    }

    public boolean close() {
        boolean rs=false;
        try{
            this.pstm.close();
            this.conn.close();
        } catch (SQLException e) {
            logger.saveLogger("数据库连接关闭失败", Arrays.toString(e.getStackTrace()));
            rs=false;
        }
        return rs;
    }
}
