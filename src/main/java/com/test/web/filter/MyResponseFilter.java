package com.test.web.filter;


import com.test.web.MyHttpServletResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/20/2017
 * Time: 13:26
 * To change this template use File | Settings | File Templates.
 */
public class MyResponseFilter implements Filter {
    private FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse)servletResponse;
        String encoding = httpServletRequest.getHeader("Accept-Encoding");
        if(encoding != null && encoding.indexOf("gzip")>-1){
            System.out.println("encoding==="+encoding);
            MyHttpServletResponseWrapper myHttpServletResponseWrapper = new MyHttpServletResponseWrapper(httpServletResponse);
            httpServletResponse.addHeader("Content-Encoding","gzip");
            System.out.println("before header=====");
            filterChain.doFilter(httpServletRequest,myHttpServletResponseWrapper);
            System.out.println("after header=====");
            myHttpServletResponseWrapper.flushBuffer();

            myHttpServletResponseWrapper.close();

            /*GZIPOutputStream gzipOutputStream = myHttpServletResponseWrapper.getGzipOutputStream();
            System.out.println("gzip===="+gzipOutputStream);
            gzipOutputStream.finish();*/
        }else {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
    }

    @Override
    public void destroy() {
        config = null;
    }
}
