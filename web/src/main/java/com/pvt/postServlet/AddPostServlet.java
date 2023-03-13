package com.pvt.postServlet;


import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.entity.Post;
import com.pvt.dao.entity.User;
import com.pvt.service.serviceImpl.PostServiceImpl;
import com.pvt.service.serviceImpl.UserServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddPostServlet", urlPatterns = {"/addPost"})
public class AddPostServlet extends HttpServlet {

    private static UserServiceImpl userService = UserServiceImpl.getInstance();
    private static PostServiceImpl postService = PostServiceImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/addPost.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        String postName = request.getParameter("postName");
        String postText = request.getParameter("postText");

        long loggedInUserId = (Long) session.getAttribute("loggedInUserId");

        User loggedInUser;
        Post userPost = new Post();

        try {
            loggedInUser = userService.get(loggedInUserId);
        } catch (LogDAOException e) {
            throw new RuntimeException(e);
        }

        userPost.setPostName(postName);
        userPost.setPostText(postText);
        userPost.setUser(loggedInUser);

        try {
            postService.add(userPost);
            PrintWriter out = response.getWriter();
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/welcome.jsp");
            rd.include(request, response);
            out.print("<p style=\"color:green\"> Post added successfully &#128077 </p>");
            out.close();
        } catch (LogDAOException e) {
            throw new RuntimeException(e);
        }
    }
}
