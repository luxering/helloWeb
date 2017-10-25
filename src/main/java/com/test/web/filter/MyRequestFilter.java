package com.test.web.filter;

import com.test.java.User;
import com.test.util.JDBCConnectionUtil;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/20/2017
 * Time: 11:35
 * To change this template use File | Settings | File Templates.
 */
public class MyRequestFilter implements Filter {
    private FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession httpSession = ((HttpServletRequest)servletRequest).getSession();
        System.out.println("id==="+httpSession.getId());
        if(httpSession.isNew()){
            System.out.println("id==="+httpSession.getId());
        }
        Cookie[] cookies = ((HttpServletRequest)servletRequest).getCookies();
        System.out.println("cookies=="+ Arrays.toString(cookies));
        int user_id = 0;
        for (int i=0,len=cookies.length;i<len;i++){
            if(cookies[i].getName().indexOf("user_id")!=-1){
                try {
                    user_id = Integer.valueOf(cookies[i].getValue());
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println("user_id=="+user_id);
        if(user_id>0){
            try (Connection connection = JDBCConnectionUtil.getConnection()) {
                Statement statement = connection.createStatement();
                String sql = "SELECT user_id,username,password FROM user WHERE user_id =" + user_id;
                System.out.println("sql=="+sql);
                ResultSet resultSet = statement.executeQuery(sql);
                if(resultSet.next()){
                    User user = new User();
        //            user.setUser_id(1);
                    user.setUsername(resultSet.getString("username"));
                    user.setUser_avatar_url(resultSet.getString("user_avatar_url"));
        //            user.setRegister_time(new Date().getTime()-1000000);
                    ((HttpServletRequest) servletRequest).getSession().setAttribute("user",user);
                }
                resultSet.close();
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        config = null;
    }
}
