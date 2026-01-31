import objects.DBHandler;

public class Main {
    public static void main(String[] args) {
        DBHandler db = new DBHandler();
        int numberOfRoutes = db.sizeOfRoutePresets();
        System.out.println(numberOfRoutes);
        for (int i=1; i < numberOfRoutes+1; i++){
            System.out.println(i);
            String routeName = db.getRoutePresetName(i);
            System.out.println("<div>" + routeName+ "</div>");
            System.out.println("<br>");
        }
    }
}
