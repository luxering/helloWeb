package com.test.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/20/2017
 * Time: 13:32
 * To change this template use File | Settings | File Templates.
 */
public class MyHttpServletResponseWrapper extends HttpServletResponseWrapper {
    private GZIPServletOutputStream gzipServletOutputStream;
    private PrintWriter printWriter;
    public MyHttpServletResponseWrapper(HttpServletResponse response) {
        super(response);
    }

    public GZIPOutputStream getGzipOutputStream(){
        return this.gzipServletOutputStream.gzipOutputStream;
    }

    public void close() throws IOException {

        //PrintWriter.close does not throw exceptions.
        //Hence no try-catch block.
        if (this.printWriter != null) {
            this.printWriter.close();
        }

        if (this.gzipServletOutputStream != null) {
            this.gzipServletOutputStream.close();
        }
    }

    @Override
    public void flushBuffer() throws IOException {
        //PrintWriter.flush() does not throw exception
        if(this.printWriter != null) {
            this.printWriter.flush();
        }

        IOException exception1 = null;
        try{
            if(this.gzipServletOutputStream != null) {
                this.gzipServletOutputStream.flush();
            }
        } catch(IOException e) {
            exception1 = e;
        }

        IOException exception2 = null;
        try {
            super.flushBuffer();
        } catch(IOException e){
            exception2 = e;
        }

        if(exception1 != null) throw exception1;
        if(exception2 != null) throw exception2;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if(printWriter == null){
            throw new IllegalStateException("printWriter already exists...");
        }
        if(gzipServletOutputStream == null){
            gzipServletOutputStream = new GZIPServletOutputStream( getResponse().getOutputStream());

        }
        return gzipServletOutputStream;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (this.printWriter == null && this.gzipServletOutputStream != null) {
            throw new IllegalStateException(
                    "OutputStream obtained already - cannot get PrintWriter");
        }
        if(printWriter == null){
            gzipServletOutputStream = new GZIPServletOutputStream( getResponse().getOutputStream());

            printWriter = new PrintWriter(new OutputStreamWriter(gzipServletOutputStream,getResponse().getCharacterEncoding()));
        }
        return printWriter;
    }
}
