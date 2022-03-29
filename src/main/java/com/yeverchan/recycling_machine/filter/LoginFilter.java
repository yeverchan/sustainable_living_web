package com.yeverchan.recycling_machine.filter;

import org.springframework.util.PatternMatchUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    static String[] publicList = new String[]{"/", "/login", "/register/*", "/resources/*", "/store/home", "/store/detail"};
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getRequestURI();
        HttpSession session = request.getSession(false);

        if (!PatternMatchUtils.simpleMatch(publicList, path)) {
            if (session == null || session.getAttribute("auth") == null) {
                if(path.contains("purchase")){
                    session.setAttribute("path", request.getHeader("referer"));
                    response.sendRedirect("/login");
                    return;
                }
                session.setAttribute("path", path);
                response.sendRedirect("/login");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
