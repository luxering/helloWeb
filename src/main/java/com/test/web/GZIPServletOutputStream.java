package com.test.web;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: luxer
 * Date: 10/20/2017
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 */
public class GZIPServletOutputStream extends ServletOutputStream {
    GZIPOutputStream gzipOutputStream;

    public GZIPServletOutputStream(ServletOutputStream outputStream) throws IOException {
        this.gzipOutputStream = new GZIPOutputStream(outputStream);
    }

    @Override
    public boolean isReady() {
        return false;
    }

    @Override
    public void setWriteListener(WriteListener writeListener) {

    }

    @Override
    public void close() throws IOException {
        this.gzipOutputStream.close();
    }

    @Override
    public void flush() throws IOException {
        this.gzipOutputStream.flush();
    }

    @Override
    public void write(byte b[]) throws IOException {
        this.gzipOutputStream.write(b);
    }

    @Override
    public void write(byte b[], int off, int len) throws IOException {
        this.gzipOutputStream.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        this.gzipOutputStream.write(b);
    }
}
