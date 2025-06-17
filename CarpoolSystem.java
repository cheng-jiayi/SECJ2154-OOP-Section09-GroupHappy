import java.util.ArrayList;

public class CarpoolSystem {
    private ArrayList<User> users;
    private ArrayList<Carpool> carpools;

    public CarpoolSystem() {
        this.users = new ArrayList<>();
        this.carpools = new ArrayList<>();
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void createCarpool(Carpool cp) {
        carpools.add(cp);
    }

    public void listCarpools() {
        for (Carpool cp : carpools) {
            cp.offerRide();
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Carpool> getCarpools() {
        return carpools;
    }
}