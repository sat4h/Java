package com.javamaster.controller;

import com.javamaster.model.GameModel;
import com.javamaster.service.GameServiceImpl;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println(uri);

        if (uri.equals("/index")) {
            List<GameModel> games = GameServiceImpl.getInstance().getAllGames();
            request.setAttribute("games", games);
            request.setAttribute("welcomeMessage", "Hi user");
            request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
        } else if (uri.equals("/addGame")) {
            if ("GET".equals(request.getMethod())) {
                request.getRequestDispatcher("/WEB-INF/view/addGame.jsp").forward(request, response);
            } else {
                String title = request.getParameter("title");
                int year = Integer.parseInt(request.getParameter("year"));
                float cost = Float.parseFloat(request.getParameter("cost"));
                float rate = Float.parseFloat(request.getParameter("rate"));
                GameServiceImpl.getInstance().addGame(title, year, cost, rate);
                response.sendRedirect(request.getContextPath() + "/index");
            }
        } else if (uri.startsWith("/delete")) {
            String gameId = uri.substring(uri.lastIndexOf("/") + 1);
            int id = Integer.parseInt(gameId);
            GameServiceImpl.getInstance().deleteGameById(id);
            response.sendRedirect(request.getContextPath() + "/index");
        } else if (uri.startsWith("/edit")) {
            if ("GET".equals(request.getMethod())) {
                String gameId = uri.substring(uri.lastIndexOf("/") + 1);
                int id = Integer.parseInt(gameId);
                GameModel game = GameServiceImpl.getInstance().getGameById(id);
                request.setAttribute("game", game);
                request.getRequestDispatcher("/WEB-INF/view/editGame.jsp").forward(request, response);
            } else if ("POST".equals(request.getMethod())) {
                int id = Integer.parseInt(request.getParameter("id"));
                String title = request.getParameter("title");
                int year = Integer.parseInt(request.getParameter("year"));
                float cost = Float.parseFloat(request.getParameter("cost"));
                float rate = Float.parseFloat(request.getParameter("rate"));
                GameServiceImpl.getInstance().editGame(id, title, year, cost, rate);
                response.sendRedirect(request.getContextPath() + "/index");
            }
             
            
        } else {
            request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}