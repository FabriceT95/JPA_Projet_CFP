package com.example.projet_cfp_jakarta.servlet;

import com.example.projet_cfp_jakarta.dao.ClientDao;
import com.example.projet_cfp_jakarta.models.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/app/clients/delete")
public class DeleteClientServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idClient = req.getParameter("idClientDelete");

        try {
            Long id = Long.parseLong(idClient);
            ClientDao clientDao = new ClientDao();
            Optional<Client> client = clientDao.get(id);
            if(client.isPresent()) {
                clientDao.delete(id);
            } else {
                System.err.println("Client not found ! Can't delete it !");
            }
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }

        resp.sendRedirect(req.getContextPath() + "/app/clients");
    }
}
