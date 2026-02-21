package org.example.scavengerhuntnea;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import objects.Location;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/UserQRCodeScannerServlet")
public class UserQRCodeScannerServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // retrieving Route from session and storing it as an attribute for JSTL in MainNav JSP
        HttpSession session = req.getSession();
        ArrayList<Location> UnvisitedLocations = (ArrayList<Location>) session.getAttribute("UnvisitedLocations");

        req.setAttribute("UnvisitedLocations", UnvisitedLocations);
        RequestDispatcher rd = req.getRequestDispatcher("/userInterface/userQRCodeScanner.jsp");
        rd.forward(req, res);
    }
}
