package objects;

import java.util.ArrayList;

public class LocationRoute {
    private String name;
    private ArrayList<Location> route = new ArrayList<>();

    // constructor 1: parameter - location id (used with preset routes)
    public LocationRoute(int routeID){
        DBHandler db = new DBHandler();
        String routePath = db.getRoutePath(routeID);
        String regex = "/";
        String[] arrayLocations = routePath.split(regex);
        for (String s : arrayLocations) {
            route.add(db.createLocationfromID(Integer.parseInt(s)));
        }
    }

    // constructor 2: parameter - string of location_ids (used with custom routes)
    public LocationRoute(String routeAsString){
        DBHandler db = new DBHandler();
        String regex = "/";
        String[] arrayLocations = routeAsString.split(regex);
        for (String s : arrayLocations) {
            route.add(db.createLocationfromID(Integer.parseInt(s)));
        }
    }

    // getters
    public ArrayList<Location> getRoute() {
        return route;
    }
}