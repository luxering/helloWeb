package com.test.web.listener;

import com.test.java.Book;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/9/2017
 * Time: 18:23
 * To change this template use File | Settings | File Templates.
 */
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String title = servletContext.getInitParameter("bookTitle");
        String author = servletContext.getInitParameter("bookAuthor");
        Book book = new Book(title,author);
        servletContext.setAttribute("book",book);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
