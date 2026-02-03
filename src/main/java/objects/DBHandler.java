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

    // LOCATIONS TABLE
    /**
     * Generates a location object from locationID
     * @param locationID
     * @return location object (including question and answers)
     */
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

    /**
     * @param correctField
     * @param locationID
     * @return correct answer as a String
     */
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

    /**
     * @param locationID
     * @return name of location as a String
     */
    public String getLocationName(int locationID) {
        String sql = "SELECT name FROM locations WHERE location_id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, locationID);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString("name");
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > getallLocationNames");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return number of records in locations table (int)
     */
    public int sizeOfLocations(){
        String sql = "SELECT COUNT(location_id) FROM locations";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("COUNT(location_id)");
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > sizeOfLocations");
            e.printStackTrace();
            return -1;
        }
    }

    // PRESET_ROUTES TABLE
    /**
     * @param routeID
     * @return routePath as String
     */
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

    /**
     * @param routeName
     * @return routePath as String
     */
    public String getRoutePath(String routeName){
        String sql = "SELECT * FROM preset_routes WHERE name =?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, routeName);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString("route_path");
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > getRoutePresetName");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param routeID
     * @return routeName as String
     */
    public String getRoutePresetName(int routeID){
        String sql = "SELECT name FROM preset_routes WHERE route_id =?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, routeID);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString("name");
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > getRoutePresetName");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @return length of (how many records there are) in the preset_routes table
     */
    public int sizeOfRoutePresets(){
        String sql = "SELECT COUNT(route_id) FROM preset_routes";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("COUNT(route_id)");
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > sizeOfRoutePresets");
            e.printStackTrace();
            return -1;
        }
    }

    // USER_INFO TABLE
    /**
     * Inserts data into user_info table
     * @param age
     * @param gender
     * @param currentschool
     * @param currentschoolOther
     * @param reasonforvisit
     * @param reasonforvisitOther
     */
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
