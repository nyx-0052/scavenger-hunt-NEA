package org.example.scavengerhuntnea;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import objects.DBHandler;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/AdminAddALocationServlet")
public class AdminAddALocationServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DBHandler db = new DBHandler();
        // for validation function - validating route name
        ArrayList<String> listOfLocationsNames = new ArrayList<>();
        int numberOfLocations = db.sizeOfLocations();
        for (int i = 1; i < numberOfLocations+1; i++) {
            String tempName = db.getLocationName(i);
            listOfLocationsNames.add(tempName.toUpperCase());
        }
        req.setAttribute("listOfLocationsNames", listOfLocationsNames);


        // for user feedback after submission to database
        HttpSession session = req.getSession();
        Object databaseFeedback = session.getAttribute("AddLocationDatabaseFeedback");
        if (databaseFeedback != null){
            req.setAttribute("AddLocationDatabaseFeedback", databaseFeedback);
        }
        // clearing it so the message does not appear repeatedly when the page is launched
        session.setAttribute("AddLocationDatabaseFeedback", "");

        RequestDispatcher rd = req.getRequestDispatcher("/adminInterface/adminAddLocation.jsp");
        rd.forward(req, res);
    }
}
