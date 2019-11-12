package com.learn.src.service.imp;

import com.learn.src.dao.User;
import com.learn.src.service.IRegister;
import com.learn.src.service.IToDatabase;
import com.learn.src.util.imp.DatabaseUtil;

import java.util.Iterator;
import java.util.Map;

public class Register implements  IToDatabase {
    User user=null;
    public Register(Map<String,String> map){
        user= new User(map);
    }

    public boolean saveToDatabase() {
        User user=this.user;
        DatabaseUtil util=new DatabaseUtil("yangyunxia");
        String key_sql="insert into "+user.getClass().getSimpleName() +"(";
        String  value_sql=user.getClass()+") values(";
        Map<String, String> allKeyValue = user.getAllKeyValue();
        Iterator<String> iterator = allKeyValue.keySet().iterator();
        while (iterator.hasNext()){
           String data= iterator.next();
           if(iterator.hasNext()){
               key_sql=key_sql.concat(data).concat(",");
               value_sql=value_sql.concat(allKeyValue.get(data)).concat(",");
           }else{
               key_sql=key_sql.concat(data)+"";
               value_sql=value_sql.concat(allKeyValue.get(data));
           }
        }
        String sql=key_sql.concat(value_sql).concat(")");
        return util.insert(sql);
    }
}
