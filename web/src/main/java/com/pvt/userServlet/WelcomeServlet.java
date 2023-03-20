package com.pvt.userServlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "WelcomeServlet", urlPatterns = {"/welcome"})
public class WelcomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/welcome.jsp");
        rd.forward(request, response);
    }
    public void doPost (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/welcome.jsp");
        rd.forward(request, response);
    }
}
