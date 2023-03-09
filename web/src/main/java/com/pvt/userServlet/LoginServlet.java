package com.pvt.userServlet;

import com.pvt.daoImpl.UserDAOImpl;
import com.pvt.entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    private static UserDAOImpl userDAO = new UserDAOImpl();

    @Override
    protected  void  doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        response.setContentType("text/html");

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");

        HttpSession session = request.getSession();

        User loginUser;

        if (userDAO.getUserByName(userName) != null){
            loginUser = userDAO.getUserByName((userName));
            if (loginUser.getUserPassword().equals(userPassword)){
                if(session != null){
                    session.setAttribute("loggedInUserId", loginUser.getUserId());
                    session.setAttribute("loggedInUserName",loginUser.getUserName());
                    session.setAttribute("loggedInUserEmail", loginUser.getUserEmail());
                    session.setAttribute("loggedInUserRole", loginUser.getUserRole());
                    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/welcome.jsp");
                    rd.forward(request, response);
                }

            }else {
                PrintWriter out = response.getWriter();
                out.print("<p style=\"color:red\"> User Name or Password error &#128512&#128529 </p>");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
                out.close();
            }
        }else {
            PrintWriter out = response.getWriter();
            out.print("<p style=\"color:red\"> User Name or Password error &#128512&#128529 </p>");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request, response);
            out.close();
        }
    }
}
