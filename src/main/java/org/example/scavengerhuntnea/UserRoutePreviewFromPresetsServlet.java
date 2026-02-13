package org.example.scavengerhuntnea;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import objects.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/UserRoutePreviewFromPresetsServlet")
public class UserRoutePreviewFromPresetsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String preset = req.getParameter("preset");

        DBHandler db = new DBHandler();
        LocationRoute chosenpreset = new LocationRoute(db.getRoutePath(preset));
        ArrayList<Location> routeofLocations = chosenpreset.getRoute();

        // for displaying purposes in JSP
        req.setAttribute("headerName", preset);
        req.setAttribute("listOfLocations", routeofLocations);
        RequestDispatcher rd = req.getRequestDispatcher("/userInterface/userRoutePreview.jsp");
        rd.forward(req, res);

        // for accessing the route in Main Nav
        HttpSession session = req.getSession();
        session.setAttribute("LocationRouteArrayList", routeofLocations);
    }
}
