package com.imooc.sertlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class CheckLogin extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        resp.setContentType("text/html; charset=UTF-8");
        if (username.equals("admin") && password.equals("123456")) {
            System.out.println("用户登录成功");
//             请求转发
             req.getRequestDispatcher("/index").forward(req, resp);
//             请求转发，使用属性传值
            req.setAttribute("username", username);
            req.getRequestDispatcher("/index").forward(req, resp);

//             响应重定向, 请求属性设置不适合响应重定向，因为是两次请求，在第一次请求结束后会进行销毁属性, 此时需要的是session会话进行设置了
//            resp.sendRedirect("/index");

        } else {
            System.out.println("用户登录失败");
        }
    }
}
