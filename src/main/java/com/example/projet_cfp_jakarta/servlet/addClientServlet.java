package com.example.projet_cfp_jakarta.servlet;

import com.example.projet_cfp_jakarta.dao.ClientDao;
import com.example.projet_cfp_jakarta.models.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(urlPatterns = "/app/clients/add")
public class addClientServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(req.getContextPath()+"/WEB-INF/add-client.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("clientName");
        String email = req.getParameter("clientEmail");
        String address = req.getParameter("clientAddress");
        String city = req.getParameter("clientCity");
        int phoneNumber = Integer.parseInt(req.getParameter("clientPhoneNumber"));
        String postalCode = req.getParameter("clientPostalCode");

        ClientDao clientDao = new ClientDao();

        Client client = new Client(name,address,postalCode,city,phoneNumber,email);

        clientDao.save(client);

        resp.sendRedirect(req.getContextPath() + "/app/clients");


    }

}
