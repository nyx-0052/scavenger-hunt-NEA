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

    /**
     * Inserts data into preset_routes table
     * @param routeName
     * @param routePath
     * @return integer - 1 is a successful insert, 0 is a failure
     */
    public int addNewPresetRoute(String routeName, String routePath) {
        String sql = "INSERT INTO preset_routes (name, route_path) VALUES (?,?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, routeName);
            stmt.setString(2, routePath);
            stmt.executeUpdate();
            return 1;
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > addNewPresetRoute");
            e.printStackTrace();
            return 0;
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

    /**
     * @return length of (how many records there are) in the user_info table
     */
    public int sizeOfUserInfo(){
        String sql = "SELECT COUNT(user_id) FROM user_info";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("COUNT(user_id)");
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > sizeOfUserInfo");
            e.printStackTrace();
            return -1;
        }
    }

    /**
     * GENDER - Counts the number of answers which have the value (parameter)
     * @param value
     * @return number of answers
     */
    public int countGender(int value){
        String sql = "SELECT COUNT(gender) FROM user_info WHERE gender =?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, value);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("COUNT(gender)");
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > countGender");
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * AGE - Counts the number of answers which have the value (parameter)
     * @param value
     * @return number of answers
     */
    public int countAge(int value){
        String sql = "SELECT COUNT(age) FROM user_info WHERE age =?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, value);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("COUNT(age)");
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > countAge");
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * REASON FOR VISIT - Counts the number of answers which have the value (parameter)
     * @param value
     * @return number of answers
     */
    public int countReasonForVisit(int value){
        String sql = "SELECT COUNT(reason_for_visit) FROM user_info WHERE reason_for_visit =?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, value);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("COUNT(reason_for_visit)");
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > countReasonForVisit");
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @param userID
     * @return other reasons for visiting as a String
     */
    public String getReasonForVisitOther(int userID){
        String sql = "SELECT * FROM user_info WHERE user_id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString("reason_for_visit_other");
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > getRoutePath");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * CURRENT SCHOOL - Counts the number of answers which have the value (parameter)
     * @param value
     * @return number of answers
     */
    public int countCurrentSchool(int value){
        String sql = "SELECT COUNT(current_schl) FROM user_info WHERE current_schl =?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, value);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("COUNT(current_schl)");
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > countCurrentSchool");
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @param userID
     * @return other current schools as a String
     */
    public String getCurrentSchoolOther(int userID){
        String sql = "SELECT * FROM user_info WHERE user_id = ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getString("current_schl_other");
        } catch (SQLException e) {
            System.out.println("Error in objects.DBHandler > getCurrentSchoolOther");
            e.printStackTrace();
            return null;
        }
    }
}
