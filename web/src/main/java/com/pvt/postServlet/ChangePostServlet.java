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
import java.io.PrintWriter;

@WebServlet(name = "ChangePostServlet", urlPatterns = {"/changePost"})
public class ChangePostServlet extends HttpServlet {

    private final PostService<Post> postService = PostServiceImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long savedPostId = Long.parseLong(request.getParameter("savePostId"));

        HttpSession session = request.getSession();
        session.setAttribute("updatePostId", savedPostId);

        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/changePost.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        long postIdToChange = (Long) session.getAttribute("updatePostId");

        String newPostName = request.getParameter("newPostName");
        String newPostText = request.getParameter("newPostText");

        Post postToChange;

        try {
            postToChange = postService.get(postIdToChange);
            postToChange.setPostName(newPostName);
            postToChange.setPostText(newPostText);
            postService.changeData(postToChange);
        } catch (LogDAOException e) {
            throw new RuntimeException(e);
        }

        PrintWriter out = response.getWriter();
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/welcome.jsp");
        rd.include(request, response);
        out.print("<p style=\"color:green\"> Post changed successfully &#128077 </p>");
        out.close();

    }
}
