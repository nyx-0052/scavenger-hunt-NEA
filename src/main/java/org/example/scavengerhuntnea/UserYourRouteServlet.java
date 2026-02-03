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
import java.util.Arrays;

@WebServlet("/UserYourRouteServlet")
public class UserYourRouteServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String[] chosenLocationIDs = req.getParameterValues("checkedlocation");
        ArrayList<Location> chosenLocationObjects = new ArrayList<Location>();

        DBHandler db = new DBHandler();
        for (int i=0; i < chosenLocationIDs.length; i++){
            Location tempLocation = db.createLocationfromID(Integer.parseInt(chosenLocationIDs[i]));
            chosenLocationObjects.add(tempLocation);
        }

        req.setAttribute("chosenLocations", chosenLocationObjects);
        RequestDispatcher rd = req.getRequestDispatcher("/userInterface/userYourRoute.jsp");
        rd.forward(req, res);
    }
}
