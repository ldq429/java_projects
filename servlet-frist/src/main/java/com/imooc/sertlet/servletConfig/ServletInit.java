package com.imooc.sertlet.servletConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class ServletInit extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init " + config.getInitParameter("file") + " ...");
    }
}
