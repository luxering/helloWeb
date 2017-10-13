package com.test.web;

import com.test.java.User;

import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/13/2017
 * Time: 15:14
 * To change this template use File | Settings | File Templates.
 */
public class UserInfoPageServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getHttpServletMapping().getMatchValue());//  1
        System.out.println(req.getContextPath());// /helloweb
        System.out.println(req.getServletPath());// /user
        System.out.println(req.getRequestURL());//  http://localhost:8080/helloweb/user/1
        System.out.println(req.getPathInfo());//    /1
        System.out.println(req.getRequestURI());//  /helloweb/user/1

        int user_id = Integer.valueOf(req.getPathInfo().split("/")[1]);
        System.out.println(user_id);

        //mysql

        //test
        /*String username = "";
        Cookie cookies[] = req.getCookies();
        for(int i=0,len=cookies.length;i<len;i++){
            if(cookies[i].getName().indexOf("username")!=-1){
                username = cookies[i].getValue();
            }
        }*/
        User user = new User();
        user.setUser_id(user_id);
        user.setUsername("myhello");
        user.setSign_up_date(new Date().getTime());
        user.setUser_img_url("https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/5f/5f786f156545ed8ec0772ce809d5b90f0dd7a9e2_full.jpg");
        req.setAttribute("user",user);
        req.getRequestDispatcher("/userInfo/userInfo.jsp").forward(req,resp);
//        req.getRequestDispatcher("/fail.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
