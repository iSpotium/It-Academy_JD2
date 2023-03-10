package com.pvt.userServlet;

import com.pvt.daoImpl.UserDAOImpl;
import com.pvt.entity.User;
import com.pvt.validation.UserValidation;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdatePasswordServlet", urlPatterns = {"/updatePassword"})
public class UpdatePasswordServlet extends HttpServlet {

    private static UserDAOImpl userDAO = new UserDAOImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/updatePassword.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String newUserPassword = request.getParameter("newPassword");

        HttpSession session = request.getSession();

        User linkUser;
        Long userIdToFind = (Long) session.getAttribute("loggedInUserId");

        linkUser = userDAO.get(userIdToFind);

        if (UserValidation.isPasswordCorrect(newUserPassword)) {
            if (session != null) {
                linkUser.setUserPassword(newUserPassword);
                userDAO.changeData(linkUser);
                PrintWriter out = response.getWriter();
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/welcome.jsp");
                rd.include(request, response);
                out.print("<p style=\"color:green\"> Password changed successfully &#128077 </p>");
                out.close();
            }
        } else {
            PrintWriter out = response.getWriter();
            out.print("<p style=\"color:red\"> Password change error &#128551 </p>");
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/updatePassword.jsp");
            rd.include(request, response);
            out.close();
        }
    }
}
