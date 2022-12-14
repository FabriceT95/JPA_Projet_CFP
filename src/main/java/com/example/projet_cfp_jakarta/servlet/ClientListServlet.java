package com.example.projet_cfp_jakarta.servlet;

import com.example.projet_cfp_jakarta.dao.ClientDao;
import com.example.projet_cfp_jakarta.models.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/app/clients")
public class ClientListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ClientDao clientDao = new ClientDao();
        System.out.println("ALL CLIENTS");
        List<Client> clientList = clientDao.getAll();
        req.setAttribute("clientList", clientList);
        req.getRequestDispatcher(req.getContextPath() + "/WEB-INF/list-client.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
