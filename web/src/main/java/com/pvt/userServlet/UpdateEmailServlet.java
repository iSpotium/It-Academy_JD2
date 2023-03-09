package com.pvt.userServlet;

import com.pvt.daoException.LogDAOException;
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
import java.sql.SQLException;

@WebServlet(name = "UpdateEmailServlet", urlPatterns = {"/updateEmail"})
public class UpdateEmailServlet extends HttpServlet {

    private static UserDAOImpl userDAO = new UserDAOImpl();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/updateEmail.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String newUserEmail = request.getParameter("newEmail");
        String acceptPassword = request.getParameter("acceptPassword");

        HttpSession session = request.getSession();

        User linkUser;
        Long userIdToFind = (Long) session.getAttribute("loggedInUserId");
        linkUser = userDAO.get(userIdToFind);


        try {
            if (UserValidation.isHaveUserWithUserEmail(newUserEmail) == false && linkUser.getUserPassword().equals(acceptPassword)) {
                if (session != null) {
                    linkUser.setUserEmail(newUserEmail);
                    userDAO.changeData(linkUser);
                    session.setAttribute("loggedInUserEmail", linkUser.getUserEmail());
                    PrintWriter out = response.getWriter();
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/welcome.jsp");
                    rd.include(request, response);
                    out.print("<p style=\"color:green\"> Email changed successfully &#128077 </p>");
                    out.close();

                }
            } else {
                PrintWriter out = response.getWriter();
                out.print("<p style=\"color:red\"> Email change error &#128551 </p>");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/updateEmail.jsp");
                rd.include(request, response);
                out.close();
            }
        } catch (LogDAOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
