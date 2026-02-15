package org.example.scavengerhuntnea;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import objects.DBHandler;
import objects.Location;
import objects.LocationRoute;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/UserMainNavServlet")
public class UserMainNavServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ArrayList<Location> route = (ArrayList<Location>) session.getAttribute("LocationRouteArrayList");

//        // (A) School Map
//        ArrayList<ArrayList> coords = new ArrayList<>();
//        for (int i=0; i< route.size(); i++){
//            ArrayList<int>
//        }

        // adding cookie
        Cookie points = new Cookie("user_points", "0");
        res.addCookie(points);

        req.setAttribute("route", route);
        RequestDispatcher rd = req.getRequestDispatcher("/userInterface/userMainNav.jsp");
        rd.forward(req, res);
    }
}
