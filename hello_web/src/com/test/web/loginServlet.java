package com.test.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class loginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //PrintWriter out = resp.getWriter();
        //out.print("hello im fine too,ty!");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username=="+username+",password=="+password);
        System.out.println("username.equals==="+username.equals("hello")+",username=="+(username=="hello"));
        System.out.println("password.equals==="+password.equals("world")+",password=="+(password=="world"));
        if(username.equals("hello") && password.equals("world")){
            //req.getRequestDispatcher("success.jsp").forward(req,resp);
            resp.sendRedirect("success.jsp");
        }else{
            //req.getRequestDispatcher("fail.jsp").forward(req,resp);
            resp.sendRedirect("fail.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
