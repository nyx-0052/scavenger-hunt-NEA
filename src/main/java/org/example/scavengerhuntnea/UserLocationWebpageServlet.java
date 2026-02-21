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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/UserLocationWebpageServlet")
public class UserLocationWebpageServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int locationID = Integer.parseInt(req.getParameter("locationID"));
        DBHandler db = new DBHandler();
        Location location = db.createLocationfromID(locationID);

        req.setAttribute("locationObject", location);
        RequestDispatcher rd = req.getRequestDispatcher("/userInterface/userLocationWebpage.jsp");
        rd.forward(req, res);
    }
}
