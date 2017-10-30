
package com.test.web;


import com.test.exception.UserAlreadyLoginException;
import com.test.java.User;
import com.test.util.JDBCConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;
import java.util.Date;

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
        /*System.out.println(req.getRequestURL());// http://localhost:8080/helloweb/register
        System.out.println(req.getRequestURI());//  /helloweb/register
        System.out.println(req.getContextPath());// /helloweb
        System.out.println(req.getServletPath());// /register
        System.out.println(req.getPathInfo());//    null*/

        try {
            Cookie[] cookies = req.getCookies();
            for(Cookie cookie : cookies){
                if(/*cookie.getName().equals("username") || */cookie.getName().equals("user_id")){
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
        if(req.getServletPath().indexOf("login")!=-1){
            System.out.println("signin...");
            req.setCharacterEncoding("utf-8");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.println("username==" + username + ",password==" + password);
            Connection connection = null;
//            Statement statement = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            try {
                connection = JDBCConnectionUtil.getConnection();
                /*statement = connection.createStatement();
                String sql = "SELECT id,username,password,user_avatar_url,register_date FROM user WHERE username = '"+username +"' AND password = '"+password+"'";
                resultSet = statement.executeQuery(sql);*/
                String sql = "SELECT id,username,password,user_avatar_url,register_date FROM user WHERE username = ? AND password = ?";
                System.out.println("sql==="+sql);
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,username);
                preparedStatement.setString(2,password);
                resultSet = preparedStatement.executeQuery();
                System.out.println("sql==="+sql);
                if(resultSet.next()){
                    int user_id = resultSet.getInt("id");
                    Cookie cookie = new Cookie("user_id",Integer.toString(user_id));
                    Cookie cookie1 = new Cookie("username",username);
                    resp.addCookie(cookie);
                    resp.addCookie(cookie1);
                    /*String url = resultSet.getString("user_avatar_url");
                    User user = new User(user_id);
                    user.setUsername(username);
                    user.setUser_avatar_url(url);
                    req.getSession().setAttribute("user",user);*/
                    req.setAttribute("msg","Login");
                    req.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(req,resp);
                }else {
                    req.setAttribute("msg","Login Failure!");
                    req.getRequestDispatcher("WEB-INF/pages/fail.jsp").forward(req,resp);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    /*if(statement != null) {
                        statement.close();
                    }*/
                    if(preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if(connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            /*if (username.equals("myhello") && password.equals("myworld")) {
                int user_id = 1;
                Cookie cookie1 = new Cookie("username", username);
                Cookie cookie2 = new Cookie("user_id", Integer.toString(user_id));
                cookie2.setMaxAge(60*60*5);
                resp.addCookie(cookie1);
                resp.addCookie(cookie2);
                req.setAttribute("msg","Login");
                req.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(req,resp);
//            resp.sendRedirect(req.getContextPath());
            }else {
                req.getRequestDispatcher("/WEB-INF/pages/fail.jsp").forward(req,resp);
            }*/
        }else if(req.getServletPath().indexOf("register")!=-1){
            System.out.println("register");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String password1 = req.getParameter("password_1");
            if(password.equals(password1)){
                /*User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setRegister_date(new Date());*/
                try (Connection connection = JDBCConnectionUtil.getConnection()) {
                    connection.setAutoCommit(false);
                    Statement statement = connection.createStatement();
                    /*Date date = new Date();
                    java.sql.Date d = new java.sql.Date(date.getTime());
                    System.out.println("date=="+date);
                    System.out.println("d==="+d);*/
                    String sql = "INSERT INTO user(username,password) VALUES('"+username+"','"+password+"');";
                    System.out.println("sql==="+sql);
                    int rows = statement.executeUpdate(sql);
                    if(rows==0){
                        connection.rollback();
                    }else {
                        connection.commit();
                    }
                    statement.close();
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
//                System.out.println("signUp_date==="+user.getRegister_date());
                req.setAttribute("msg","Register");
                req.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(req,resp);
            }else{

            }
        }
    }
}
