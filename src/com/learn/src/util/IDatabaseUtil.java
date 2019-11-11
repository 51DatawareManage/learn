package com.learn.src.util;

import com.alibaba.fastjson.JSONObject;
import com.learn.src.util.imp.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;

public interface IDatabaseUtil {
    /**
     *
     * @param db 数据库名称
     * @return 返回db数据库的连接信息
     */
    public JSONObject getDatabaseInfo(String db);

    /**
     *
     * @param db 数据库名称
     * @return 返回 db对应的数据的连接
     */
    public void changeDB(String db);
    /**
     *
     * @param db 需要获取的数据库名称
     * @return 返回数据库操作连接
     */
    public void getDatabase(String db);

    /**
     *
     * @param sql 需要查询的sql
     * @return 返回查询结果集
     */
    public ResultSet  query(String sql);
    /**
     *
     * @param sql 需要执行的sql
     * @return 返回执行结果（false：失败 true：成功）
     */
    public boolean excute(String sql);

    /**
     *
     * @param sql 需要插入的sql
     * @return 返回执行结果（false：失败 true：成功）
     */
    public  boolean insert(String sql);

    /**
     *
     * @param sql 要更新的sql
     * @return 返回执行结果（false：失败 true：成功）
     */
    public boolean update(String sql);

    /**
     *
     * @param sql 要删除数据的sql
     * @return 返回执行结果（false：失败 true：成功）
     */
    public boolean delete(String sql);
}
