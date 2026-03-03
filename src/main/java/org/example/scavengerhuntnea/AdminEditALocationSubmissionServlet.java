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

@WebServlet("/AdminEditALocationSubmissionServlet")
public class AdminEditALocationSubmissionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int locationID = Integer.parseInt(req.getParameter("locationID"));
        String name = req.getParameter("locationName");
        int xcoord = Integer.parseInt(req.getParameter("xcoordValue"));
        int ycoord = Integer.parseInt(req.getParameter("ycoordValue"));
        String descp = req.getParameter("descp");
        String schoolLink = req.getParameter("schoolLink");

        String question = req.getParameter("question");
        String option1 = req.getParameter("option1");
        String option2 = req.getParameter("option2");
        String option3 = req.getParameter("option3");
        int correctOption = Integer.parseInt(req.getParameter("correctOption"));

        DBHandler db = new DBHandler();
        db.updateQuestion(question, option1, option2, option3, correctOption, locationID);
        int insertResult = db.updateLocation(name, xcoord, ycoord, descp, schoolLink, locationID);

        // user feedback
        HttpSession session = req.getSession();
        session.setAttribute("EditLocationDatabaseFeedback", insertResult);

        RequestDispatcher rd = req.getRequestDispatcher("/AdminEditALocationServlet");
        rd.forward(req, res);
    }
}
