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

@WebServlet("/AdminDataAnalysisServlet")
public class AdminDataAnalysisServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        DBHandler db = new DBHandler();
        int numberOfEntries = db.sizeOfUserInfo();
        ArrayList<Integer> genderData = new ArrayList<Integer>();
        ArrayList<Integer> ageData = new ArrayList<Integer>();
        ArrayList<Integer> reasonForVisitData = new ArrayList<Integer>();
        ArrayList<String> reasonForVisitOther = new ArrayList<String>();
        ArrayList<Integer> currentSchoolData = new ArrayList<Integer>();
        ArrayList<String> currentSchoolOther = new ArrayList<String>();

        // populating each arrayList with the data
        for(int i=1; i<5; i++){
            ageData.add(db.countAge(i));
        }
        for(int i=1; i<4; i++){
            genderData.add(db.countGender(i));
        }
        for(int i=1; i<6; i++){
            reasonForVisitData.add(db.countReasonForVisit(i));
        }
        for(int i=1; i<5; i++){
            currentSchoolData.add(db.countCurrentSchool(i));
        }

        for (int i=1; i < numberOfEntries+1; i++){
            String tempReason=db.getReasonForVisitOther(i);
            String tempSchool=db.getCurrentSchoolOther(i);
            if(tempSchool!=null){
                currentSchoolOther.add(tempSchool);
            }
            if(tempReason!=null){
                reasonForVisitOther.add(tempReason);
            }
        }

        req.setAttribute("ageData", ageData);
        req.setAttribute("genderData", genderData);
        req.setAttribute("reasonForVisitData", reasonForVisitData);
        req.setAttribute("currentSchoolData", currentSchoolData);
        req.setAttribute("reasonForVisitOther", reasonForVisitOther);
        req.setAttribute("currentSchoolOther", currentSchoolOther);
        RequestDispatcher rd = req.getRequestDispatcher("/adminInterface/adminDataAnalysis.jsp");
        rd.forward(req, res);
    }
}
