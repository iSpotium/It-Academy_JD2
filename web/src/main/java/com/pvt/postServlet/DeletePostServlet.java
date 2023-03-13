package com.pvt.postServlet;

import com.pvt.dao.daoException.LogDAOException;
import com.pvt.service.serviceImpl.PostServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeletePostServlet", urlPatterns = {"/deletePost"})
public class DeletePostServlet extends HttpServlet {

    private static PostServiceImpl postService = PostServiceImpl.getInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long postIdToDelete = Long.parseLong(request.getParameter("savePostId"));


        try {
            postService.delete(postIdToDelete);
        } catch (LogDAOException e) {
            throw new RuntimeException();
        }

        PrintWriter out = response.getWriter();
        out.print("<p style=\"color:green\"> Post deleted successfully &#128077 </p>");
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/welcome.jsp");
        rd.include(request, response);
        out.close();
    }

}

