import java.util.ArrayList;

public class CarpoolSystem {
    private final ArrayList<User> users;
    private final ArrayList<Carpool> carpools;

    public CarpoolSystem() {
        this.users = new ArrayList<>();
        this.carpools = new ArrayList<>();
    }

    // Registers a new user
    public void registerUser(User user) {
        users.add(user);
    }

    // Creates a new carpool and adds it to the list
    public void createCarpool(Carpool cp) {
        carpools.add(cp);
    }

    // Returns all registered users
    public ArrayList<User> getUsers() {
        return users;
    }

    // Returns all active carpools
    public ArrayList<Carpool> getCarpools() {
        return carpools;
    }

    // Lists carpools with detailed output
    public void listCarpoolsWithPassengers() {
        if (carpools.isEmpty()) {
            System.out.println("No carpools available.");
            return;
        }

        for (int i = 0; i < carpools.size(); i++) {
            final int index = i;
            System.out.print(index + ". ");
            printBox(() -> {
                Carpool c = carpools.get(index);
                c.offerRide();
                c.showPassengers();
            });
        }
    }

    // Lists CO2 saved reports for all carpools
    public void listCO2Reports() {
        if (carpools.isEmpty()) {
            System.out.println("No carpools available for CO2 calculation.");
            return;
        }

        for (int i = 0; i < carpools.size(); i++) {
            final int index = i;
            printBox(() -> {
                Carpool c = carpools.get(index);
                c.offerRide();
                Carpool.printCO2Report(c);
            });
        }
    }

    // Utility method to wrap print in a visual box
    private void printBox(Runnable content) {
        System.out.println();
        System.out.println("--------------------------------------------------------------------------");
        content.run();
        System.out.println("--------------------------------------------------------------------------");
    }
}
