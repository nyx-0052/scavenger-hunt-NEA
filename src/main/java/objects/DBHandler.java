package objects;

import java.sql.*;

public class DBHandler {
    Connection con;

    public DBHandler() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scavengerHuntNEA", "root", "root");
            System.out.println("Connected!");
        } catch (Exception e) {
            System.out.println("Could not connect to the database.");
            System.out.println(e);
        }
    }

    public Location createLocationfromID(int locationID) {
        String sql = "SELECT * FROM locations JOIN qna ON locations.question_id = qna.question_id WHERE location_id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, locationID);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            String name = rs.getString("name");
            int xcoord = rs.getInt("xcoord");
            int ycoord = rs.getInt("ycoord");
            String descp = rs.getString("descp");
            String schoolLink = rs.getString("school_link");
            String question = rs.getString("question");
            int correctAns = rs.getInt("correct_ans");
            String option1 = rs.getString("option_1");
            String option2 = rs.getString("option_2");
            String option3 = rs.getString("option_3");

            Location location = new Location(locationID, name, xcoord, ycoord, descp, schoolLink, question, correctAns, option1, option2, option3);
            return location;
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > createLocationfromID");
            e.printStackTrace();
            return null;
        }
    }

    public String getCorrectAnswer(String correctField, int locationID) {
        String sql = "SELECT * FROM qna WHERE question_id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, locationID);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString(correctField);
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > getCorrectAnswer");
            e.printStackTrace();
            return null;
        }
    }

    public String getRoutePath(int routeID){
        String sql = "SELECT * FROM preset_routes WHERE route_id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, routeID);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString("route_path");
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > getRoutePath");
            e.printStackTrace();
            return null;
        }
    }

    public void addUserInfo(int age, int gender, int currentschool, String currentschoolOther, int reasonforvisit, String reasonforvisitOther){
        String sql;
        if (currentschoolOther.isEmpty() && reasonforvisitOther.isEmpty()){
            sql = "INSERT INTO user_info (age, gender, reason_for_visit, current_schl) VALUES (?,?,?,?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, age);
                stmt.setInt(2,gender);
                stmt.setInt(3, reasonforvisit);
                stmt.setInt(4, currentschool);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error in objects.DBHandler > addUserInfo");
                e.printStackTrace();
            }
        } else if (currentschoolOther.isEmpty()){
            sql = "INSERT INTO user_info (age, gender, reason_for_visit, reason_for_visit_other, current_schl) VALUES (?,?,?,?,?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, age);
                stmt.setInt(2,gender);
                stmt.setInt(3, reasonforvisit);
                stmt.setString(4,reasonforvisitOther);
                stmt.setInt(5, currentschool);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error in objects.DBHandler > addUserInfo");
                e.printStackTrace();
            }
        } else if (reasonforvisitOther.isEmpty()){
            sql = "INSERT INTO user_info (age, gender, reason_for_visit, current_schl, current_schl_other) VALUES (?,?,?,?,?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, age);
                stmt.setInt(2,gender);
                stmt.setInt(3, reasonforvisit);
                stmt.setInt(4,currentschool);
                stmt.setString(5, currentschoolOther);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error in objects.DBHandler > addUserInfo");
                e.printStackTrace();
            }
        } else{
            sql = "INSERT INTO user_info (age, gender, reason_for_visit, reason_for_visit_other, current_schl, current_schl_other) VALUES (?,?,?,?,?,?)";
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                stmt.setInt(1, age);
                stmt.setInt(2,gender);
                stmt.setInt(3, reasonforvisit);
                stmt.setString(4, reasonforvisitOther);
                stmt.setInt(5,currentschool);
                stmt.setString(6, currentschoolOther);
                stmt.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error in objects.DBHandler > addUserInfo");
                e.printStackTrace();
            }
        }
    }
}
