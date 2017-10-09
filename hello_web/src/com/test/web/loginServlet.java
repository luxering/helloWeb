package com.test.web;

import com.test.java.Book;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/8/2017
 * Time: 10:13
 * To change this template use File | Settings | File Templates.
 */
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
//        String email = getServletConfig().getInitParameter("email");
//        System.out.println("email=="+email);
        String email = getServletContext().getInitParameter("adminEmail");
        System.out.println("adminEmail=="+email);
        Book book = (Book) getServletContext().getAttribute("book");
        System.out.println("book:"+book.getTitle()+"==="+book.getAuthor());
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
