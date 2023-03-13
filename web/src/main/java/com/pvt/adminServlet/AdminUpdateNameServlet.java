package com.pvt.adminServlet;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.daoImpl.UserDAOImpl;
import com.pvt.dao.entity.User;
import com.pvt.dao.validation.UserValidation;
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
import java.sql.SQLException;

@WebServlet(name = "AdminUpdateNameServlet", urlPatterns = {"/adminUpdateName"})
public class AdminUpdateNameServlet extends HttpServlet {
    private static UserServiceImpl userService = UserServiceImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long savedUserId = Long.parseLong(request.getParameter("saveUserId"));

        HttpSession session = request.getSession();
        session.setAttribute("updateUserId", savedUserId);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/adminUpdateName.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();

        String newUserName = request.getParameter("newName");
        long userIdToFind = (Long) session.getAttribute("updateUserId");
        User linkUser;


        try {
            if (UserValidation.isHaveUserWithUserName(newUserName) == false) {
                if (session != null) {
                    linkUser = userService.get(userIdToFind);
                    linkUser.setUserName(newUserName);
                    userService.changeData(linkUser);
                    PrintWriter out = response.getWriter();
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/changeData.jsp");
                    rd.include(request, response);
                    out.print("<p style=\"color:green\"> Name changed successfully &#128077 </p>");
                    out.close();

                }
            } else {
                PrintWriter out = response.getWriter();
                out.print("<p style=\"color:red\"> Name change error &#128551 </p>");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/adminUpdateName.jsp");
                rd.include(request, response);
                out.close();
            }
        } catch (LogDAOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
