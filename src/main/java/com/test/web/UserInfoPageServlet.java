package com.test.web;

import com.test.exception.UserNotFoundException;
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

//        System.out.println(req.getHttpServletMapping().getMatchValue());//  1
        System.out.println(req.getRequestURL());//  http://localhost:8080/helloweb/profile/1
        System.out.println(req.getRequestURI());//  /helloweb/profile/1
        System.out.println(req.getContextPath());// /helloweb
        System.out.println(req.getServletPath());// /profile
        System.out.println(req.getPathInfo());//    /1

        try {
            if(req.getPathInfo() == null || req.getPathInfo().equals("/")){
                throw new UserNotFoundException("没有该用户...");
            }
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
            if(user_id != 1){
                throw  new UserNotFoundException("没有该用户...");
            }
            User user = new User();
            user.setUser_id(user_id);
            user.setUsername("myhello");
            user.setRegister_date(new Date());
            user.setUser_avatar_url("https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/5f/5f786f156545ed8ec0772ce809d5b90f0dd7a9e2_full.jpg");
            req.setAttribute("user",user);
            req.getRequestDispatcher("/WEB-INF/pages/user/user.jsp").forward(req,resp);
        //        req.getRequestDispatcher("/fail.jsp").forward(req,resp);
        }catch (UserNotFoundException e){
            e.getMessage();
            e.printStackTrace();
            System.out.println("user no found,but i lived");
            req.getRequestDispatcher("/WEB-INF/pages/userNotFound.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
