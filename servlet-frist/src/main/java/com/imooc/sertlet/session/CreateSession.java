package com.imooc.sertlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/session/create")
public class CreateSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = new Random().nextInt(1000);
        HttpSession session = req.getSession();
        session.setAttribute("random", i);
        session.setMaxInactiveInterval(60 * 60 * 24);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("设置session成功session：" + i);
    }
}
