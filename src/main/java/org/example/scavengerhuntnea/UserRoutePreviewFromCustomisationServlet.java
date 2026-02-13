package org.example.scavengerhuntnea;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import objects.DBHandler;
import objects.Location;
import objects.LocationRoute;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/UserRoutePreviewFromCustomisationServlet")
public class UserRoutePreviewFromCustomisationServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String[] chosenLocationIDs = req.getParameterValues("checkedlocation");
        ArrayList<Location> chosenLocationObjects = new ArrayList<Location>();

        DBHandler db = new DBHandler();
        for (int i=0; i < chosenLocationIDs.length; i++){
            Location tempLocation = db.createLocationfromID(Integer.parseInt(chosenLocationIDs[i]));
            chosenLocationObjects.add(tempLocation);
        }

        // for displaying purposes in JSP
        req.setAttribute("headerName", "Your Route");
        req.setAttribute("listOfLocations", chosenLocationObjects);
        RequestDispatcher rd = req.getRequestDispatcher("/userInterface/userRoutePreview.jsp");
        rd.forward(req, res);

        // for accessing the route in Main Nav
        HttpSession session = req.getSession();
        session.setAttribute("LocationRouteArrayList", chosenLocationObjects);
    }
}
