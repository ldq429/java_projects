package com.imooc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PlatformAdaptationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String uri = req.getRequestURI(); // /index.html -> /mobile/index.html | /pc/index.html
        if (uri.startsWith("/mobile") || uri.startsWith("/pc")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String userAgent = req.getHeader("user-agent");
            String targetUri = null;
            if (userAgent.toLowerCase().contains("android") || userAgent.toLowerCase().contains("iphone")) {
                targetUri = "/mobile" + uri;
            } else {
                targetUri = "/pc" + uri;
            }
            // 重定向到对象的uri
            resp.sendRedirect(targetUri);
        }

    }

    @Override
    public void destroy() {

    }
}
