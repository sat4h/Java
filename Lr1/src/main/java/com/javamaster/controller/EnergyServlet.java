package com.javamaster.controller;

import com.javamaster.model.EnergyModel;
import com.javamaster.service.EnergyServiceImpl;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnergyServlet extends HttpServlet {

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
    String contextPath = request.getContextPath();

    if (uri.equals("/main-page")) {
        List<EnergyModel> energy_drinks = EnergyServiceImpl.getInstance().getAllEnergys();
        request.setAttribute("energy_drinks", energy_drinks);
        request.setAttribute("welcomeMessage", "Hi user");
        request.getRequestDispatcher("/WEB-INF/view/main-page.jsp").forward(request, response);
    } else if ((contextPath + "/addEnergy").equals(uri)) {
            if ("GET".equals(request.getMethod())) {
                request.getRequestDispatcher("/WEB-INF/view/addEnergy.jsp").forward(request, response);
            } else {
                String title = request.getParameter("title");
                float cost = Float.parseFloat(request.getParameter("cost"));
                float rate = Float.parseFloat(request.getParameter("rate"));
                EnergyServiceImpl.getInstance().addEnergy(title, cost, rate);
                response.sendRedirect(request.getContextPath() + "/main-page");
            }
        } else if (uri.startsWith("/deleteEnergy")) {
            String energyId = uri.substring(uri.lastIndexOf("/") + 1);
            int id = Integer.parseInt(energyId);
            EnergyServiceImpl.getInstance().deleteEnergyById(id);
            response.sendRedirect(request.getContextPath() + "/main-page");
        } else if (uri.startsWith("/editEnergy")) {
            if ("GET".equals(request.getMethod())) {
                String energyId = uri.substring(uri.lastIndexOf("/") + 1);
                int id = Integer.parseInt(energyId);
                EnergyModel energy = EnergyServiceImpl.getInstance().getEnergyById(id);
                request.setAttribute("energy", energy);
                request.getRequestDispatcher("/WEB-INF/view/editEnergy.jsp").forward(request, response);
            } else if ("POST".equals(request.getMethod())) {
                int id = Integer.parseInt(request.getParameter("id"));
                String title = request.getParameter("title");
                float cost = Float.parseFloat(request.getParameter("cost"));
                float rate = Float.parseFloat(request.getParameter("rate"));
                EnergyServiceImpl.getInstance().editEnergy(id, title, cost, rate);
                response.sendRedirect(request.getContextPath() + "/main-page");
            }
         } else {
        request.getRequestDispatcher("/WEB-INF/view/main-page.jsp").forward(request, response);
    }
}

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}