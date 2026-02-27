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

@WebServlet("/AdminRoutePreviewSubmissionServlet")
public class AdminRoutePreviewSubmissionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DBHandler db = new DBHandler();
        HttpSession session = req.getSession();
        String formattedRoute =  req.getParameter("formattedRoute");
        String routeName = req.getParameter("routeName");

        boolean insertResult = db.addNewPresetRoute(routeName, formattedRoute);
        // for user feedback
        if(insertResult){
            session.setAttribute("AddRouteDatabaseFeedback", 1);
        }else{
            session.setAttribute("AddRouteDatabaseFeedback", 0);
        }
        RequestDispatcher rd = req.getRequestDispatcher("/AdminAddANewPresetServlet");
        rd.forward(req, res);
    }
}
