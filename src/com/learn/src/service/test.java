package com.learn.src.service;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class test extends HttpServlet {

    public void init() throws ServletException {

    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        // 接收参数
        String value = req.getParameter("username");
        System.out.println(value);
        //向浏览器回写数据
        //req.setAttribute("username",value);
        resp.sendRedirect("http://localhost:8088/learn/staticpage/login.html");
    }
    public void destroy() {

    }

}
