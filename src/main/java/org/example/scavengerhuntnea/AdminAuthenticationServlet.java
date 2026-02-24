package org.example.scavengerhuntnea;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/AdminAuthenticationServlet")
public class AdminAuthenticationServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String userInput = req.getParameter("password");
        String correctPassword = "Fettes1870scavengerNEA!";

        if (userInput.equals(correctPassword)){
            RequestDispatcher rd = req.getRequestDispatcher("/adminInterface/adminDataAnalysis.jsp");
            rd.forward(req, res);
        } else{
            req.setAttribute("incorrect", "1");
            RequestDispatcher rd = req.getRequestDispatcher("/adminInterface/adminAuthentication.jsp");
            rd.forward(req, res);
        }

    }
}
