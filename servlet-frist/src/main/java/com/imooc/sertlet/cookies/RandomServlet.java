package com.imooc.sertlet.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/cookie/create")
public class RandomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int i = new Random().nextInt(1000);
        Cookie cookie = new Cookie("random", String.valueOf(i));
        cookie.setMaxAge(60 * 60 * 24);// 单位为秒
        resp.addCookie(cookie);
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println("生成cookie成功，cookie值为：" + i);

    }
}
