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

@WebServlet("/UserChooseYourLocationServlet")
public class UserChooseYourLocationServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<Location> listofLocations = new ArrayList<>();
        DBHandler db = new DBHandler();
        int numberOfLocations = db.sizeOfLocations();
        for (int i = 1; i < numberOfLocations+1; i++) {
            Location location = db.createLocationfromID(i);
            listofLocations.add(location);
        }
        req.setAttribute("listofLocations", listofLocations);
        RequestDispatcher rd = req.getRequestDispatcher("/userInterface/userChooseYourLocation.jsp");
        rd.forward(req, res);
    }
}
