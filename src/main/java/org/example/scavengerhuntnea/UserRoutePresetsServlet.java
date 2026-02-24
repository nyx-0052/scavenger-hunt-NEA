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

@WebServlet("/UserRoutePresetsServlet")
public class UserRoutePresetsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList <String> listOfPresetNames = new ArrayList<>();
        DBHandler db = new DBHandler();
        int numberOfRoutes = db.sizeOfRoutePresets();
        for (int i=1; i < numberOfRoutes+1; i++){
            String routeName = db.getRoutePresetName(i);
            listOfPresetNames.add(routeName);
        }
        req.setAttribute("listOfPresetNames", listOfPresetNames);
        RequestDispatcher rd = req.getRequestDispatcher("/userInterface/userRoutePreset.jsp");
        rd.forward(req, res);
    }
}
