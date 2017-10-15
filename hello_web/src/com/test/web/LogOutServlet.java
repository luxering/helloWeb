package com.test.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
