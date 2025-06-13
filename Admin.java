public class Admin extends User {

    public Admin() {
        super("Admin", "admin@example.com", 30, "Other", "0000000000");
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin Name: " + name);
        System.out.println("Email: " + email);
    }

    public void viewReport(Carpool carpool) {
        System.out.println("========== Carpool Report ==========");
        System.out.println("Route: " + carpool.getRoute().getOPickUpPoint() + " to " + carpool.getRoute().getDropPoint());
        System.out.println("Driver: " + carpool.getDriver().getName());
        System.out.println("Total Seats: " + carpool.getMaxPassengers());
        System.out.println("Available Seats: " + (carpool.getMaxPassengers() - carpool.getPassengers().size()));
        System.out.println("Passengers: ");
        for (User u : carpool.getPassengers()) {
            System.out.println(" - " + u.getName());
        }
        System.out.println("Estimated CO₂ Saved: " + carpool.calculateCO2Saved() + " kg");
        System.out.println("====================================");
    }
}
