package org.example.scavengerhuntnea;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import objects.DBHandler;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/UserChooseYourLocationServlet")
public class UserChooseYourLocationServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<String> listofLocations = new ArrayList<>();
        ArrayList<Integer> listofLocationIDs = new ArrayList<>();
        int tempID = 1;
        DBHandler db = new DBHandler();
        int numberOfLocations = db.sizeOfLocations();
        for (int i = 1; i < numberOfLocations+1; i++) {
            String locationName = db.getLocationName(i);
            listofLocations.add(tempID + ". "+ locationName);
            listofLocationIDs.add(tempID);
            tempID++;
        }
        req.setAttribute("listofLocationNames", listofLocations);
        req.setAttribute("listofLocationIDs", listofLocationIDs);
        req.setAttribute("sizeofLocationNames", listofLocations.size());
        RequestDispatcher rd = req.getRequestDispatcher("/userInterface/userChooseYourLocation.jsp");
        rd.forward(req, res);
    }
}
