import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBHandler {
    Connection con;

    public DBHandler(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/scavengerHuntNEA", "root", "root");
            System.out.println("Connected!");
        } catch (Exception e) {
            System.out.println("Could not connect to the database.");
            System.out.println(e);
        }
    }

    public void testSQL(){
        String sql = "SELECT COUNT(gender) FROM user_info WHERE gender = 1";
        try (PreparedStatement stmt = con.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int gender = rs.getInt("COUNT(gender)");
            System.out.println(gender);
        } catch(Exception e){
            System.out.println("Error in DBHandler > testSQL");
            e.printStackTrace();
        }
    }
}
