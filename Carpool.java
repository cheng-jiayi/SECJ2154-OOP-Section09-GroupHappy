import java.util.ArrayList;

public class Carpool implements RideShareable {
    private User driver;
    private int maxPassengers;
    private ArrayList<User> passengers;
    private Route route;

    private String make;
    private String model;
    private String color;
    private String licensePlate;
    private String licenseNumber;

    public Carpool(User driver, int maxPassengers, Route route,
                   String make, String model, String color,
                   String licensePlate, String licenseNumber) {
        this.driver = driver;
        this.maxPassengers = maxPassengers;
        this.route = route;
        this.passengers = new ArrayList<>();

        this.make = make;
        this.model = model;
        this.color = color;
        this.licensePlate = licensePlate;
        this.licenseNumber = licenseNumber;
    }

    @Override
    public void offerRide() {
        System.out.println("\nRide offered by:");
        driver.displayInfo();
        route.displayRoute();
        System.out.println("Vehicle: " + color + " " + make + " " + model);
        System.out.println("Plate: " + licensePlate + " | License No: " + licenseNumber);
        System.out.println("Available seats: " + (maxPassengers - passengers.size()));
    }

    @Override
    public void joinRide(User user) throws FullCarpoolException {
        if (user.email.equalsIgnoreCase(driver.email)) {
            System.out.println("Error: Driver cannot join their own ride as a passenger.");
            return;
        }

        if (passengers.size() >= maxPassengers) {
            throw new FullCarpoolException("Ride is full!");
        }

        for (User u : passengers) {
            if (u.email.equalsIgnoreCase(user.email)) {
                System.out.println("User already joined this ride.");
                return;
            }
        }

        passengers.add(user);
        System.out.println(user.name + " has joined the ride.");
    }

    public double calculateCO2Saved() {
        return passengers.size() * 0.5;
    }

    public void showPassengers() {
        System.out.println("Passengers:");
        for (User u : passengers) {
            u.displayInfo();
        }
    }

    public User getDriver() {
        return driver;
    }

    public Route getRoute() {
        return route;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public List<User> getPassengers() {
        return passengers;
    }
}
