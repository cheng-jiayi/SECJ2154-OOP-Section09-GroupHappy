import java.util.ArrayList;

public class Carpool implements RideShareable {
    private final User driver;
    private final int maxPassengers;
    private final ArrayList<User> passengers;
    private final Route route;

    private final String make;
    private final String model;
    private final String color;
    private final String licensePlate;
    private final String licenseNumber;

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
        System.out.println("Available seats: " + getAvailableSeats());
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
        // Assuming each passenger saves 0.5 kg CO2 per ride
        return passengers.size() * 0.5;
    }

    public void showPassengers() {
        if (passengers.isEmpty()) {
            System.out.println("No passengers yet.");
        } else {
            System.out.println("Passengers:");
            for (User u : passengers) {
                u.displayInfo();
            }
        }
    }

    public int getAvailableSeats() {
        return maxPassengers - passengers.size();
    }

    public User getDriver() {
        return driver;
    }

    public static void printCO2Report(Carpool carpool) {
        System.out.printf("Estimated CO2 saved: %.2f kg\n", carpool.calculateCO2Saved());
    }
}
