// TEST FROM ITERATION 1: DB CONNECTION
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
//        System.out.println("Error in objects.DBHandler > testSQL");
//        e.printStackTrace();
//    }
//}

// TESTS FROM ITERATION 2: CLASSES AND OBJECTS
//objects.Location l1 = db.createLocationfromID(1);
//        System.out.println(l1);
//        System.out.println(l1.getXcoord());
//        System.out.println(l1.getOption());
//
//objects.LocationRoute route1 = new objects.LocationRoute(3);
//        System.out.println(route1.getRoute());
//
//objects.LocationRoute route2 = new objects.LocationRoute("3/6/9/12/3");
//        System.out.println(route2.getRoute());

