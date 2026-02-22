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

@WebServlet("/UserPostLocationSubmissionServlet")
public class UserPostLocationSubmissionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int justVisitedLocationID = Integer.parseInt(req.getParameter("locationID"));

        HttpSession session = req.getSession();
        ArrayList<Location> unvisitedLocations = (ArrayList<Location>) session.getAttribute("UnvisitedLocations");
        ArrayList<Location> visitedLocations = (ArrayList<Location>) session.getAttribute("VisitedLocations");

        // a. removing location that user just visited from unvisitedLocations and adding to visitedLocations
        boolean found = false;
        int counter = 0;
        while (!found && counter < unvisitedLocations.size()){
            Location compareLocation = unvisitedLocations.get(counter);
            if(compareLocation.getLocationID() == justVisitedLocationID){
                found = true;
                unvisitedLocations.remove(counter);
                visitedLocations.add(compareLocation);
            } else{
                counter++;
            }
        }

        session.setAttribute("UnvistedLocations", unvisitedLocations);
        session.setAttribute("VisitedLocations", visitedLocations);

        // b. redirecting to servlet based on check
        if (unvisitedLocations.isEmpty()){
            RequestDispatcher rd = req.getRequestDispatcher("/userInterface/userEndingPage.jsp");
            rd.forward(req, res);
        } else{
            req.setAttribute("route", unvisitedLocations);
            RequestDispatcher rd = req.getRequestDispatcher("/userInterface/userMainNav.jsp");
            rd.forward(req, res);
        }
    }
}
