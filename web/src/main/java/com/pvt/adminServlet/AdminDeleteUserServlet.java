package com.pvt.adminServlet;

import com.pvt.daoImpl.UserDAOImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AdminDeleteUserServlet", urlPatterns = {"/adminDeleteUser"})
public class AdminDeleteUserServlet extends HttpServlet {

    private static UserDAOImpl userDAO = new UserDAOImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long userIdToDelete = Long.parseLong(request.getParameter("saveUserId"));
        userDAO.delete(userIdToDelete);
        PrintWriter out = response.getWriter();
        out.print("<p style=\"color:green\"> User Delete successfully &#128077 </p>");
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/changeData.jsp");
        rd.include(request, response);
        out.close();
    }

}
