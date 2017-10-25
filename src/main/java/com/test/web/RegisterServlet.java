package com.test.web;

import com.test.util.JDBCConnectionUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/13/2017
 * Time: 20:52
 * To change this template use File | Settings | File Templates.
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //validate
        //register
//        req.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(req,resp);
//        resp.sendRedirect("success.jsp");
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        System.out.println("username=="+username);
        PrintWriter printWriter = resp.getWriter();
        try (Connection connection = JDBCConnectionUtil.getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "SELECT user_id,username FROM user WHERE username = '" + username +"'";
            ResultSet resultSet = statement.executeQuery(sql);
            System.out.println("resultset.rows===="+resultSet.getRow());
            if(resultSet.next()){
                printWriter.print("not available");
            }else {
                printWriter.print("ok");
            }
            resultSet.close();
            statement.close();
            printWriter.flush();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
