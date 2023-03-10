package com.pvt.userServlet;

import com.pvt.dao.DAOLogic;
import com.pvt.daoException.LogDAOException;
import com.pvt.daoImpl.UserDAOImpl;
import com.pvt.validation.CheckTheData;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "RegistrationServlet", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {

    private static UserDAOImpl userDAO = new UserDAOImpl();
    private static DAOLogic daoLogic = DAOLogic.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/registration.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String userEmail = request.getParameter("userEmail");

        String dataLine = userName + "," + userPassword + "," + userEmail;
        String[] arrayData = daoLogic.splitString(dataLine);

        try {
            if (CheckTheData.correctData(arrayData) == true) {
                userDAO.add(daoLogic.firstInitializationUser(arrayData));
                PrintWriter out = response.getWriter();
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
                out.print("<p style=\"color:green\"> User created successfully &#128077 </p>");
                out.close();
            }else{
                PrintWriter out = response.getWriter();
                out.print("<p style=\"color:red\"> Incorrect data entered &#128512&#128529 </p>");
                RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/registration.jsp");
                rd.include(request, response);
                out.close();
            }
        } catch (LogDAOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
