package com.learn.src.util;

public interface ILogger {
    /**
     *
     * @param reason 传入失败原因描述
     * @param e 传入失败原因明细
     * @return 返回是否存入成功
     */
    public boolean saveLogger(String reason,String e);
}
