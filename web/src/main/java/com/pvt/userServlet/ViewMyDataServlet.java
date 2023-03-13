package com.pvt.userServlet;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.daoImpl.UserDAOImpl;
import com.pvt.dao.entity.User;
import com.pvt.service.serviceImpl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "ViewMyDataServlet", urlPatterns = {"/viewMyData"})
public class ViewMyDataServlet extends HttpServlet {
    private static UserServiceImpl userService = UserServiceImpl.getInstance();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text.html");
        HttpSession session = request.getSession();

        User linkUser;
        Long userId = (Long) session.getAttribute("loggedInUserId");

        try {
            linkUser = userService.get(userId);
        } catch (LogDAOException e) {
            throw new RuntimeException(e);
        }

        session.setAttribute("viewUserName", linkUser.getUserName());
        session.setAttribute("viewUserEmail", linkUser.getUserEmail());
        session.setAttribute("viewUserRole", linkUser.getUserRole());
        session.setAttribute("viewUserId", linkUser.getUserId());
        session.setAttribute("viewUserPassword", linkUser.getUserPassword());

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/viewMyData.jsp");
        rd.forward(request, response);
    }
}
