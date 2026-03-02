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

@WebServlet("/AdminAddALocationSubmissionServlet")
public class AdminAddALocationSubmissionServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
        db.addNewQuestion(question, option1, option2, option3, correctOption);
        int question_id = db.getLastQuestionID();
        int insertResult = db.addNewLocation(name, xcoord, ycoord, descp, schoolLink, question_id);

        // user feedback
        HttpSession session = req.getSession();
        session.setAttribute("AddLocationDatabaseFeedback", insertResult);

        RequestDispatcher rd = req.getRequestDispatcher("/AdminAddALocationServlet");
        rd.forward(req, res);
    }
}
