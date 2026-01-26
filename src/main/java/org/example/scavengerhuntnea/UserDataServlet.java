package org.example.scavengerhuntnea;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import objects.DBHandler;

import static java.awt.SystemColor.window;

@WebServlet("/UserDataServlet")
public class UserDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int age = Integer.parseInt(request.getParameter("age"));
        int gender = Integer.parseInt(request.getParameter("gender"));
        int reasonforvisit = Integer.parseInt(request.getParameter("reasonforvisit"));
        String reasonforvisitOther="";
        int currentschool = Integer.parseInt(request.getParameter("currentschool"));
        String currentschoolOther="";

        if(reasonforvisit==5){
            reasonforvisitOther = request.getParameter("otherreasonforvisittext");
        }
        if (currentschool==4){
            currentschoolOther = request.getParameter("othercurrentschootext");
        }
        DBHandler db = new DBHandler();
        db.addUserInfo(age, gender, currentschool, currentschoolOther, reasonforvisit, reasonforvisitOther);
        RequestDispatcher rd = request.getRequestDispatcher("/userInterface/userRoutePlanning.jsp");
        rd.forward(request, response);
    }
}
