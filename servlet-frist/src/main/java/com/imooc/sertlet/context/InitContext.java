package com.imooc.sertlet.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context/init")
public class InitContext  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("servletContext","Copyright© 2023 imooc.com  京ICP备 12003892号-11 京公网安备11010802030151号 营业执照");
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("servletContext 创建成功");
        resp.getWriter().println(servletContext.getAttribute("servletContext") + "servletContext");
    }
}
