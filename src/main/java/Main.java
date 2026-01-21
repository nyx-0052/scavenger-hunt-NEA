public class Main {
    public static void main(String[] args) {
        DBHandler db = new DBHandler();
        Location l1 = db.createLocationfromID(1);
        System.out.println(l1);
        System.out.println(l1.getXcoord());
        System.out.println(l1.getOption());
    }
}
