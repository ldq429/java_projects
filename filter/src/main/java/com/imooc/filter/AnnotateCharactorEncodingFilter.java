/**
 * 注解的形式配置init-param
 */
package com.imooc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebFilter(value = "/acef",initParams = {
//        @WebInitParam(name="encoding",value="UTF-8")
////        @WebInitParam(name="encoding",value="UTF-8"),
////        @WebInitParam(name="encoding",value="UTF-8"),
//})
public class AnnotateCharactorEncodingFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        System.out.println("CharactorEncodingFilter init...");
        System.out.println("encoding" + encoding);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CharactorEncodingFilter is runing...");
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        req.setCharacterEncoding(encoding); //设置请求体类型为utf-8
        res.setContentType("text/html;charset=" + encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("CharactorEncodingFilter destroy...");
    }
}
