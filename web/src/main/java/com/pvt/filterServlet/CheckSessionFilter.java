package com.pvt.filterServlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/updateData", "/updateEmail", "/updateName", "/updatePassword", "/viewUsers", "/welcome", "/adminUpdateName", "/adminUpdatePassword", "/adminDeleteUser", "/viewMyData"})
public class CheckSessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if((session!=null) && (session.getAttribute("loggedInUserId")!=null)) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(contextPath + "/index.jsp");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
