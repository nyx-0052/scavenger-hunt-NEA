import java.util.ArrayList;

public class LocationRoute {
    private ArrayList<Location> route = new ArrayList<>();

    // constructor 1: parameter - location id (used with preset routes)
    public LocationRoute(int routeID){
        DBHandler db = new DBHandler();
        String routePath = db.getRoutePath(routeID);
        for (int i=0; i < routePath.length(); i++){
            if (routePath.charAt(i) != '/'){
                int locationID = Integer.parseInt(String.valueOf(routePath.charAt(i)));
                route.add(db.createLocationfromID(locationID));
            }
        }
    }

    // constructor 2: parameter - string of location_ids (used with custom routes)
    public LocationRoute(String routeAsString){
        DBHandler db = new DBHandler();
        for (int i=0; i < routeAsString.length(); i++){
            if (routeAsString.charAt(i) != '/'){
                int locationID = Integer.parseInt(String.valueOf(routeAsString.charAt(i)));
                route.add(db.createLocationfromID(locationID));
            }
        }
    }

    // getters
    public ArrayList<Location> getRoute() {
        return route;
    }
}