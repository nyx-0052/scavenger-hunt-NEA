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
import java.util.ArrayList;

@WebServlet("/AdminRoutePreviewServlet")
public class AdminRoutePreviewServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String presetName = req.getParameter("presetName");
        String[] chosenLocationIDs = req.getParameterValues("checkedlocation");
        ArrayList<Location> chosenLocationObjects = new ArrayList<Location>();

        DBHandler db = new DBHandler();
        for (int i = 0; i < chosenLocationIDs.length; i++) {
            Location tempLocation = db.createLocationfromID(Integer.parseInt(chosenLocationIDs[i]));
            chosenLocationObjects.add(tempLocation);
        }
        // for displaying the route in JSP
        req.setAttribute("headerName", presetName);
        req.setAttribute("listOfLocations", chosenLocationObjects);

        // formatting location IDs into a string to be stored in the database
        String formattedLocationIDs = "";
        for (int i = 0; i < chosenLocationIDs.length-1; i++) {
            formattedLocationIDs += chosenLocationIDs[i]+"/";
        }
            // adding the last location in WITHOUT a /
        formattedLocationIDs += chosenLocationIDs[chosenLocationIDs.length-1];
        req.setAttribute("formattedRoute", formattedLocationIDs);

        RequestDispatcher rd = req.getRequestDispatcher("/adminInterface/adminPresetPreview.jsp");
        rd.forward(req, res);
    }
}
