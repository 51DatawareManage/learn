package com.learn.src.dao.imp;

import com.learn.src.dao.ILearnObject;
import com.learn.src.util.imp.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class User extends LearnObject  {
    private Logger logger=new Logger();
    private Map<String,String> map=new HashMap<String, String>();
    public User(String phone,String registerEmail,String registerPassword,String reg_time){
        try{
            this.map.put("phone",phone);
            this.map.put("registerEmail",registerEmail);
            this.map.put("registerPassword",registerPassword);
            this.map.put("reg_time",reg_time);
        }catch (NullPointerException e){
            logger.saveLogger("用户信息获取失败", Arrays.toString(e.getStackTrace()));
        }

    }
    public User(Map<String,String> map){
        try{
            this.map.putAll(map);
        }catch (NullPointerException e){
            logger.saveLogger("用户信息获取失败", Arrays.toString(e.getStackTrace()));
        }
    }
    public String getPhone(){
         return this.map.get("phone");
    }
    public void setPhone(String phone){
        this.map.put("phone",phone);
    }
    public String getReg_time(){

        return this.map.get("reg_time");
    }
    public void setReg_time(String reg_time){
        this.map.put("reg_time",reg_time);
    }

    public String getRegisterEmail(){
        return this.map.get("registerEmail");
    }
    public void setRegisterEmail(String registerEmail){
        this.map.put("registerEmail",registerEmail);
    }

    public String getRegisterPassword(){
        return this.map.get("registerPassword");
    }
    public void setRegisterPassword(String registerPassword){
        this.map.put("registerPassword",registerPassword);
    }
    @Override
    public Map<String,String> getAllKeyValue(){
        return this.map;
    }
}
