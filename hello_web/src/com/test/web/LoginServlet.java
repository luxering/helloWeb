
package com.test.web;

import com.test.java.Book;
import com.test.java.User;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

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
        System.out.println(req.getHttpServletMapping().getMatchValue());//  register
        System.out.println(req.getRequestURL());// http://localhost:8080/helloweb/register
        System.out.println(req.getRequestURI());//  /helloweb/register
        System.out.println(req.getContextPath());// /helloweb
        System.out.println(req.getServletPath());// /register
        System.out.println(req.getPathInfo());//    null

        if(req.getServletPath().indexOf("register")!=-1){
            System.out.println("register...");
            req.getRequestDispatcher("user/register.jsp").forward(req,resp);
        }
        //PrintWriter out = resp.getWriter();
        //out.print("hello im fine too,ty!");
        /*String username = req.getParameter("username");
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
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("signin...");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username==" + username + ",password==" + password);
        PrintWriter out = resp.getWriter();
        /*System.out.println("username.equals==="+username.equals("myhello")+",username=="+(username=="myhello"));
        System.out.println("password.equals==="+password.equals("myworld")+",password=="+(password=="myworld"));*/
//        String email = getServletConfig().getInitParameter("email");
//        System.out.println("email=="+email);
        /*String email = getServletContext().getInitParameter("adminEmail");
        System.out.println("adminEmail=="+email);
        Book book = (Book) getServletContext().getAttribute("book");
        System.out.println("book:"+book.getTitle()+"==="+book.getAuthor());*/
        if (username.equals("myhello") && password.equals("myworld")) {
            //req.getRequestDispatcher("success.jsp").forward(req,resp);
            /*User user = new User(username,password);
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("user",user);*/
            int user_id = 1;
            Cookie cookie1 = new Cookie("username", username);
            Cookie cookie2 = new Cookie("user_id", Integer.toString(user_id));
            resp.addCookie(cookie1);
            resp.addCookie(cookie2);
            /*String userJson = "{" +
                    "username:"+ username+"," +
                    "user_id:"+ user_id +"}";
            System.out.println(userJson);
            out.print(userJson);*/
            out.print(user_id);
//            out.print("success");
            //resp.sendRedirect("success.jsp");
        } else {
            //req.getRequestDispatcher("fail.jsp").forward(req,resp);
            //resp.sendRedirect("fail.jsp");
            out.print("fail");
        }
    }
}
