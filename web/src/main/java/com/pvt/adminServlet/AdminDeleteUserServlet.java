package com.pvt.adminServlet;

import com.pvt.dao.daoException.LogDAOException;

import com.pvt.dao.entity.User;
import com.pvt.service.serviceInterface.UserService;
import com.pvt.service.serviceImpl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminDeleteUserServlet", urlPatterns = {"/adminDeleteUser"})
public class AdminDeleteUserServlet extends HttpServlet{

    private final UserService<User> userService = UserServiceImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long userIdToDelete = Long.parseLong(request.getParameter("saveUserId"));

        try {
            userService.delete(userIdToDelete);
        } catch (LogDAOException e) {
            throw new RuntimeException(e);
        }

        PrintWriter out = response.getWriter();
        out.print("<p style=\"color:green\"> User Deleted successfully &#128077 </p>");
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/changeData.jsp");
        rd.include(request, response);
        out.close();
    }
}
