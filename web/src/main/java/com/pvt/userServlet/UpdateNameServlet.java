package com.pvt.userServlet;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.daoImpl.UserDAOImpl;
import com.pvt.dao.entity.User;
import com.pvt.dao.validation.UserValidation;
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

@WebServlet(name = "UpdateNameServlet", urlPatterns = {"/updateName"})
public class UpdateNameServlet extends HttpServlet {

    private static UserDAOImpl userDAO = UserDAOImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/updateName.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        String newUserName = request.getParameter("newName");
        String acceptPassword = request.getParameter("acceptPassword");

        HttpSession session = request.getSession();

        User linkUser;
        Long userIdToFind = (Long) session.getAttribute("loggedInUserId");

        linkUser = userDAO.get(userIdToFind);


        try {
            if (UserValidation.isHaveUserWithUserName(newUserName) == false && linkUser.getUserPassword().equals(acceptPassword)) {
                if (session != null) {
                    linkUser.setUserName(newUserName);
                    userDAO.changeData(linkUser);
                    session.setAttribute("loggedInUserName", newUserName);
                    PrintWriter out = response.getWriter();
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/welcome.jsp");
                    rd.include(request, response);
                    out.print("<p style=\"color:green\"> Name changed successfully &#128077 </p>");
                    out.close();

                }
            } else {
                PrintWriter out = response.getWriter();
                out.print("<p style=\"color:red\"> Name change error &#128551 </p>");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/updateName.jsp");
                rd.include(request, response);
                out.close();
            }
        } catch (LogDAOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
