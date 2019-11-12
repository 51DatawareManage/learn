package com.learn.src.dao;

import java.util.Map;

public class User {
    private String phone=null;
    private String registerEmail=null;
    private String registerPassword=null;
    private String reg_time=null;
    public User(String phone,String registerEmail,String registerPassword,String reg_time){
        this.phone=phone;
        this.reg_time=reg_time;
        this.registerEmail=registerEmail;
        this.registerPassword=registerPassword;
    }
    public User(Map<String,String> map){
        this.phone=map.get("phone");
        this.reg_time=map.get("reg_time");
        this.registerEmail=map.get("registerEmail");
        this.registerPassword=map.get("registerPassword");
    }
    public String getPhone(){
         return this.phone;
    }
    public void setPhone(String phone){
         this.phone=phone;
    }
    public String getReg_time(){
        return this.reg_time;
    }
    public void setReg_time(String reg_time){
        this.reg_time=reg_time;
    }

    public String getRegisterEmail(){
        return this.registerEmail;
    }
    public void setRegisterEmail(String registerEmail){
        this.registerEmail=registerEmail;
    }

    public String getRegisterPassword(){
        return this.reg_time;
    }
    public void setRegisterPassword(String registerPassword){
        this.registerPassword=registerPassword;
    }
}
