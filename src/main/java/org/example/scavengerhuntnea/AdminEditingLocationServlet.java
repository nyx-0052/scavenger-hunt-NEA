package org.example.scavengerhuntnea;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import objects.DBHandler;
import objects.Location;

import java.io.IOException;

@WebServlet("/AdminEditingLocationServlet")
public class AdminEditingLocationServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DBHandler db = new DBHandler();

        int locationID = Integer.parseInt(req.getParameter("id"));
        Location chosenLocation = db.createLocationfromID(locationID);

        req.setAttribute("chosenLocation", chosenLocation);

        RequestDispatcher rd = req.getRequestDispatcher("/adminInterface/adminEditingLocation.jsp");
        rd.forward(req, res);
    }
}
