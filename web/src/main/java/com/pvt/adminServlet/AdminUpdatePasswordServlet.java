package com.pvt.adminServlet;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.entity.User;
import com.pvt.dao.validation.UserValidation;
import com.pvt.service.serviceInterface.UserService;
import com.pvt.service.serviceImpl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminUpdatePasswordServlet", urlPatterns = {"/adminUpdatePassword"})
public class AdminUpdatePasswordServlet extends HttpServlet {

    private final UserService<User> userService = UserServiceImpl.getInstance();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long saveUserId = Long.parseLong(request.getParameter("saveUserId"));

        User updateUser;

        try {
            updateUser = userService.get(saveUserId);
        } catch (LogDAOException e) {
            throw new RuntimeException(e);
        }

        if (updateUser != null) {
            HttpSession session = request.getSession();
            session.setAttribute("updateUserId", saveUserId);
        }

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/adminUpdatePassword.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();

        String newUserPassword = request.getParameter("newPassword");
        long userIdToFind = (Long) session.getAttribute("updateUserId");
        User linkUser;

        try {
            if (UserValidation.isPasswordCorrect(newUserPassword)) {
                if (session != null) {
                    linkUser = userService.get(userIdToFind);
                    linkUser.setUserPassword(newUserPassword);
                    userService.changeData(linkUser);
                    PrintWriter out = response.getWriter();
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/welcome.jsp");
                    rd.include(request, response);
                    out.print("<p style=\"color:green\"> Password changed successfully &#128077 </p>");
                    out.close();
                }
            } else {
                PrintWriter out = response.getWriter();
                out.print("<p style=\"color:red\"> Password change error &#128551 </p>");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/adminUpdatePassword.jsp");
                rd.include(request, response);
                out.close();
            }
        } catch (LogDAOException e) {
            throw new RuntimeException(e);
        }
    }

}
