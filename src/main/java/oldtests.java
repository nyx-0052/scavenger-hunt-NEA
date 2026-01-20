//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//public void testSQL(){
//    String sql = "SELECT COUNT(gender) FROM user_info WHERE gender = 1";
//    try (PreparedStatement stmt = con.prepareStatement(sql)){
//        ResultSet rs = stmt.executeQuery();
//        rs.next();
//        int gender = rs.getInt("COUNT(gender)");
//        System.out.println(gender);
//    } catch(Exception e){
//        System.out.println("Error in DBHandler > testSQL");
//        e.printStackTrace();
//    }
//}