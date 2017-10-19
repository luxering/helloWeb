
package com.test.web;


import com.test.exception.UserAlreadyLoginException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/8/2017
 * Time: 10:13
 * To change this template use File | Settings | File Templates.
 */
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getHttpServletMapping().getMatchValue());//  register
        System.out.println(req.getRequestURL());// http://localhost:8080/helloweb/register
        System.out.println(req.getRequestURI());//  /helloweb/register
        System.out.println(req.getContextPath());// /helloweb
        System.out.println(req.getServletPath());// /register
        System.out.println(req.getPathInfo());//    null

        try {
            Cookie[] cookies = req.getCookies();
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("username") || cookie.getName().equals("user_id")){
                        throw new UserAlreadyLoginException("用户已登录...");
                }
            }
        } catch (UserAlreadyLoginException e) {
            e.getMessage();
            e.printStackTrace();
            //already login send error page
            req.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(req,resp);
            return;
        }

        if(req.getServletPath().indexOf("login")!=-1){
            System.out.println("login...");
            req.getRequestDispatcher("/WEB-INF/pages/user/login.jsp").forward(req,resp);
        }else if(req.getServletPath().indexOf("register")!=-1){
            System.out.println("register...");
            req.getRequestDispatcher("/WEB-INF/pages/user/register.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("signin...");
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username==" + username + ",password==" + password);
        if (username.equals("myhello") && password.equals("myworld")) {
            int user_id = 1;
            Cookie cookie1 = new Cookie("username", username);
            Cookie cookie2 = new Cookie("user_id", Integer.toString(user_id));
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
            req.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(req,resp);
//            resp.sendRedirect(req.getContextPath());
        }
    }
}
