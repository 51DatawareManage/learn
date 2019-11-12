package com.learn.src.service.imp;

import com.learn.src.service.IRegisterServlet;
import com.learn.src.service.imp.Register;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class RegisterServlet extends HttpServlet implements IRegisterServlet {

    public void init() throws ServletException {

    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String,String> map=new HashMap<String, String>();
        map.put("phone",req.getParameter("registerUsername"));
        map.put("registerEmail",req.getParameter("registerEmail"));
        map.put("registerPassword",req.getParameter("registerPassword"));
        map.put("create_time",new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date()));
        new Register(map);

    }
    public void destroy() {

    }

}
