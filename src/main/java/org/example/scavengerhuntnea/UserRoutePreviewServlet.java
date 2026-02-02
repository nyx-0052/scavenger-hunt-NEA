package org.example.scavengerhuntnea;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import objects.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/UserRoutePreviewServlet")
public class UserRoutePreviewServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String presetname = req.getParameter("preset");

        DBHandler db = new DBHandler();
        LocationRoute chosenpreset = new LocationRoute(db.getRoutePath(presetname));
        ArrayList<Location> routeofLocations = chosenpreset.getRoute();
        ArrayList<String> locationNames = new ArrayList<>();
        for (int i = 0; i< routeofLocations.size(); i++){
            Location currentLocation = routeofLocations.get(i);
            locationNames.add(currentLocation.getName());
        }
        req.setAttribute("presetName", presetname);
        req.setAttribute("listOfLocationNames", locationNames);
        RequestDispatcher rd = req.getRequestDispatcher("/userInterface/userRoutePreview.jsp");
        rd.forward(req, res);
    }
}
