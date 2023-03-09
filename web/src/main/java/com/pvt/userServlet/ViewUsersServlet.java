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
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ViewUsersServlet", urlPatterns = {"/viewUsers"})
public class ViewUsersServlet extends HttpServlet {
    private static UserDAOImpl userDAO = new UserDAOImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text.html");
        HttpSession session = request.getSession();

        User adminUser;
        Long userIdToRemove = (Long) session.getAttribute("loggedInUserId");

        adminUser = userDAO.get(userIdToRemove);
        List<User> usersList;

        usersList = userDAO.getAllUsers();

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
