package com.test.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/10/2017
 * Time: 21:57
 * To change this template use File | Settings | File Templates.
 */
public class LogOutServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("logout...");
        Cookie[] cookies = req.getCookies();
        for(int i=0,len=cookies.length;i<len;i++){
            if(cookies[i].getName().equals("username")){
                System.out.println(cookies[i].getName()+":"+cookies[i].getValue());
                cookies[i].setValue(null);
                cookies[i].setMaxAge(0);
                System.out.println(cookies[i].getName()+":"+cookies[i].getValue());
                resp.addCookie(cookies[i]);
            }else if(cookies[i].getName().equals("user_id")){
                cookies[i].setValue(null);
                cookies[i].setMaxAge(0);
                resp.addCookie(cookies[i]);
            }
        }
        req.getSession().invalidate();
//        resp.setContentType("utf-8");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        StringBuilder builder = new StringBuilder();
//        builder.append("hello world<br/>");
        builder.append("<div class='hr_btn'>\n" +
                "                    <a href='"+ req.getContextPath() +"/login' class='hr_logInBtn' title=\'登录\'>登录</a>\n" +
                "                </div>\n" +
                "                <span class='hr_midSpan'>|</span>\n" +
                "                <div class='hr_btn'>\n" +
                "                    <a href='"+ req.getContextPath() +"/register' class='hr_signUpBtn' title=\'注册\'>注册</a>\n" +
                "                </div>");
        System.out.println(builder);
        out.print(builder);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
