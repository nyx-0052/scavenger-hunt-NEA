package org.example.scavengerhuntnea;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import objects.DBHandler;
import objects.Location;
import objects.LocationRoute;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/UserMainNavServlet")
public class UserMainNavServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // retrieving Route from session and storing it as an attribute for JSTL in MainNav JSP
        HttpSession session = req.getSession();
        ArrayList<Location> route = (ArrayList<Location>) session.getAttribute("UnvisitedLocations");
        ArrayList<Location> visitedLocations = (ArrayList<Location>) session.getAttribute("VisitedLocations");

        // adding cookie
        Cookie points = new Cookie("user_points", "0");
        res.addCookie(points);

        req.setAttribute("route", route);
        req.setAttribute("vistedLocations", visitedLocations);
        RequestDispatcher rd = req.getRequestDispatcher("/userInterface/userMainNav.jsp");
        rd.forward(req, res);
    }
}
