package com.test.web;

import com.test.exception.UserNotFoundException;
import com.test.java.User;
import com.test.util.JDBCConnectionUtil;

import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            int user_id = Integer.valueOf(req.getPathInfo().substring(1));
            System.out.println("user_id=="+user_id);


            //mysql

            //test
            /*String username = "";
            Cookie cookies[] = req.getCookies();
            for(int i=0,len=cookies.length;i<len;i++){
                if(cookies[i].getName().indexOf("username")!=-1){
                    username = cookies[i].getValue();
                }
            }*/
            /*if(user_id != 1){
                throw  new UserNotFoundException("没有该用户...");
            }*/
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            try {
                connection = JDBCConnectionUtil.getConnection();
                statement = connection.createStatement();
                String sql = "SELECT id,username,password,user_avatar_url,register_date FROM user WHERE id =" + user_id;
                System.out.println("sql==="+sql);
                resultSet = statement.executeQuery(sql);
                if(resultSet.next()){
                    User user = new User(user_id);
//                    user.setUser_id(user_id);
                    user.setUsername(resultSet.getString("username"));
                    StringBuffer stringBuffer = new StringBuffer(req.getContextPath());
                    stringBuffer.append("/");
                    stringBuffer.append(resultSet.getString("user_avatar_url"));
                    user.setUser_avatar_url(stringBuffer.toString());
                    user.setRegister_date(resultSet.getTimestamp("register_date"));
                    req.setAttribute("user",user);
                    req.getRequestDispatcher("/WEB-INF/pages/user/user.jsp").forward(req,resp);
                //        req.getRequestDispatcher("/fail.jsp").forward(req,resp);
                }else {
                    throw new UserNotFoundException("没有该用户...");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }catch (UserNotFoundException e){
            e.getMessage();
            e.printStackTrace();
            System.out.println("user no found,but i lived");
            req.setAttribute("msg","user not found!");
            req.getRequestDispatcher("/WEB-INF/pages/fail.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
