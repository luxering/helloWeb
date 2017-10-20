package com.test.web.filter;

import com.test.java.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/20/2017
 * Time: 11:35
 * To change this template use File | Settings | File Templates.
 */
public class MyRequstFilter implements Filter {
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
        int user_id = 0;
        for (int i=0,len=cookies.length;i<len;i++){
            if(cookies[i].getName().indexOf("user_id")!=-1){
                user_id = Integer.valueOf(cookies[i].getValue());
            }
        }
//        System.out.println("user_id=="+user_id);
        if(user_id>0){
            User user = new User();
//            user.setUser_id(1);
            user.setUsername("hohoho");
            user.setUser_img_url("https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/5f/5f786f156545ed8ec0772ce809d5b90f0dd7a9e2_full.jpg");
//            user.setSign_up_date(new Date().getTime()-1000000);
            ((HttpServletRequest) servletRequest).getSession().setAttribute("user",user);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
