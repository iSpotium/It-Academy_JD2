package com.pvt.userServlet;

import com.pvt.dao.daoUtils.DAOLogic;
import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.entity.User;
import com.pvt.dao.validation.CheckTheData;
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
import java.sql.SQLException;

@WebServlet(name = "RegistrationServlet", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {

    private final UserService<User> userService = UserServiceImpl.getInstance();
    private final DAOLogic daoLogic = DAOLogic.getInstance();

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
            if (CheckTheData.isTheDataCorrect(arrayData) == true) {
                userService.add(daoLogic.firstInitializationUser(arrayData));
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
