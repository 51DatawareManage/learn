package com.learn.src.util.imp;

import com.learn.src.util.IselfUtil;

public  class selfUtil implements IselfUtil {
    private static Logger logger=new Logger();
    public  static Logger getLogger(){
        return logger;
    }
}
