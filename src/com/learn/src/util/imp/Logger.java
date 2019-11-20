package com.learn.src.util.imp;

import com.learn.src.util.ILogger;

public class Logger implements ILogger {
    /**
     *
     * @param reason 失败原因描述
     * @param e 失败原因明细
     */
    public Logger(String reason, String e){
        saveLogger(reason,e);
    }

    /**
     * Logger构造方法
     */
    public Logger(){
    }

    /**
     * c
     * @param reason 传入失败原因描述
     * @param e 传入失败原因明细
     * @return 日志是否处理成功
     */
    public boolean saveLogger(String reason, String e) {
        System.out.println(reason);
        System.out.println(e);
        /**
         * 在此处进行日志处理
         */
        return false;
    }
}
