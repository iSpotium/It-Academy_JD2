package com.pvt.postServlet;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.dao.entity.Post;
import com.pvt.service.serviceInterface.PostService;
import com.pvt.service.serviceImpl.PostServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

@WebServlet(name = "ViewPostsServlet", urlPatterns = {"/viewPosts"})
public class ViewPostsServlet extends HttpServlet {

    private final PostService<Post> postService = PostServiceImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        long loggedInUserId = (Long) session.getAttribute("loggedInUserId");

        Set<Post> userPosts;

        try {
            userPosts = postService.getPostsByUserId(loggedInUserId);
        } catch (LogDAOException | SQLException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("userPosts", userPosts);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/viewPosts.jsp");
        rd.forward(request, response);
    }
}
