package com.learn.src.service.imp;
import com.learn.src.dao.imp.LearnObject;
import com.learn.src.service.IToDatabase;
import com.learn.src.util.imp.DatabaseUtil;

import java.util.Iterator;
import java.util.Map;

public class DataToDatabse implements  IToDatabase {
    private LearnObject obj=null;
    public DataToDatabse(LearnObject obj){
       this.obj=obj;
    }

    public boolean saveToDatabase() {
        DatabaseUtil util=new DatabaseUtil("yangyunxia");
        String key_sql="insert into "+obj.getClass().getSimpleName() +"(";
        String  value_sql=") values(";
        Map<String, String> allKeyValue = obj.getAllKeyValue();
        Iterator<String> iterator = allKeyValue.keySet().iterator();
        while (iterator.hasNext()){
           String data= iterator.next();
           if(iterator.hasNext()){
               key_sql=key_sql.concat(data).concat(",");
               value_sql=value_sql.concat("'"+allKeyValue.get(data)).concat("',");
           }else{
               key_sql=key_sql.concat(data)+"";
               value_sql=value_sql.concat("'"+allKeyValue.get(data)+"'");
           }
        }
        return util.insert(key_sql.concat(value_sql).concat(")"));
    }
}
