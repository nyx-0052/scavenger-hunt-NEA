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

@WebServlet("/AdminAddANewPresetServlet")
public class AdminAddANewPresetServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DBHandler db = new DBHandler();

        // for displaying each location on JSP
        ArrayList<Location> listofLocations = new ArrayList<>();
        int numberOfLocations = db.sizeOfLocations();
        for (int i = 1; i < numberOfLocations+1; i++) {
            Location location = db.createLocationfromID(i);
            listofLocations.add(location);
        }
        req.setAttribute("listofLocations", listofLocations);

        // for validation function - validating route name
        ArrayList<String> listOfPresetNames = new ArrayList<>();
        int numberOfPresets = db.sizeOfRoutePresets();
        for (int i = 1; i < numberOfPresets+1; i++) {
            String tempName = db.getRoutePresetName(i);
            listOfPresetNames.add(tempName.toUpperCase());
        }
        req.setAttribute("listOfPresetNames", listOfPresetNames);

        // for user feedback after submission to database
        HttpSession session = req.getSession();
        Object databaseFeedback = session.getAttribute("AddRouteDatabaseFeedback");
        if (databaseFeedback != null){
            req.setAttribute("AddRouteDatabaseFeedback", databaseFeedback);
        }
            // clearing it so the message does not appear repeatedly when the page is launched
        session.setAttribute("AddRouteDatabaseFeedback", "");

        RequestDispatcher rd = req.getRequestDispatcher("/adminInterface/adminAddPreset.jsp");
        rd.forward(req, res);
    }
}