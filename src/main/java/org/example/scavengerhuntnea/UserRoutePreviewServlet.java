package org.example.scavengerhuntnea;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import objects.DBHandler;
import objects.LocationRoute;

import java.io.IOException;

@WebServlet("/UserRoutePreviewServlet")
public class UserRoutePreviewServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String presetname = req.getParameter("preset");

        DBHandler db = new DBHandler();
        String routepath = db.getRoutePath(presetname);
        LocationRoute chosenroute = new LocationRoute(routepath);
    }
}
