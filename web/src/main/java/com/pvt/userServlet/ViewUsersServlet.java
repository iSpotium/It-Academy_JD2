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
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ViewUsersServlet", urlPatterns = {"/viewUsers"})
public class ViewUsersServlet extends HttpServlet {
    private static UserServiceImpl userService = UserServiceImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text.html");
        HttpSession session = request.getSession();

        User adminUser;
        Long userIdToRemove = (Long) session.getAttribute("loggedInUserId");

        try {
            adminUser = userService.get(userIdToRemove);
        } catch (LogDAOException e) {
            throw new RuntimeException(e);
        }

        List<User> usersList;

        usersList = userService.getAllUsers();

        Iterator<User> userIterator = usersList.iterator();
        while (userIterator.hasNext()){
            User user = userIterator.next();
            if(user.getUserId() == adminUser.getUserId()){
                userIterator.remove();
            }
        }
        request.setAttribute("usersList", usersList);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/viewUsers.jsp");
        rd.forward(request, response);
    }
}
