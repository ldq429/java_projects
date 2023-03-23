package com.imooc.sertlet;

//通配符匹配 例如 /class/578 | /class/579 ......

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/class/*")
public class PatternServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestURI = req.getRequestURI();
        String id = requestURI.substring(requestURI.lastIndexOf("/") + 1);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("<h1>");
        resp.getWriter().println("课程编号" + id);
        resp.getWriter().println("</h1>");
    }
}
