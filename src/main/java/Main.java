import objects.DBHandler;

import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        ArrayList<String> listofLocations = new ArrayList<>();
        DBHandler db = new DBHandler();
        int numberOfLocations = db.sizeOfLocations();
        for (int i = 1; i < numberOfLocations+1; i++) {
            String locationName = db.getLocationName(i);
            listofLocations.add(locationName);
        }
        System.out.println(listofLocations);
    }
}