package org.example.scavengerhuntnea;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import objects.DBHandler;
import objects.Location;
import objects.LocationRoute;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/UserMainNavServlet")
public class UserMainNavServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // this creates the chosen Location Route object
        String presetname = req.getParameter("chosenRouteName");
        DBHandler db = new DBHandler();
        LocationRoute chosenpreset = new LocationRoute(db.getRoutePath(presetname));

        // adding cookie
        Cookie points = new Cookie("user_points", "0");
        res.addCookie(points);

        // test
        System.out.println(points.getValue());
        System.out.println(chosenpreset.getRoute());
    }
}
