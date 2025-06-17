import java.util.Scanner;

public class CarpoolMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarpoolSystem system = new CarpoolSystem();

        while (true) {
            System.out.println("\n===== GreenGo Menu =====");
            System.out.println("1. Register User");
            System.out.println("2. Offer Ride");
            System.out.println("3. Join Ride");
            System.out.println("4. View Carpools");
            System.out.println("5. View CO2 Saved");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> registerUser(scanner, system);
                case 2 -> offerRide(scanner, system);
                case 3 -> joinRide(scanner, system);
                case 4 -> viewCarpools(system);
                case 5 -> viewCO2Saved(system);
                case 6 -> {
                    System.out.println("Thank you for using GreenGo!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void registerUser(Scanner scanner, CarpoolSystem system) {
        String name, email, gender, phone, role;
        int age;

        System.out.print("Enter name: ");
        name = scanner.nextLine();

        while (true) {
            System.out.print("Enter email: ");
            email = scanner.nextLine();
            if (email.contains("@")) break;
            System.out.println("Invalid email. Must contain '@'.");
        }

        while (true) {
            try {
                System.out.print("Enter age: ");
                age = Integer.parseInt(scanner.nextLine());
                if (age >= 0) break;
                System.out.println("Age must be 0 or above.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }

        while (true) {
            System.out.print("Enter gender (m/f): ");
            gender = scanner.nextLine().toLowerCase();
            if (gender.equals("m") || gender.equals("f")) break;
            System.out.println("Gender must be 'm' or 'f'.");
        }

        while (true) {
            System.out.print("Enter phone number (10-11 digits): ");
            phone = scanner.nextLine();
            if (phone.matches("\\d{10,11}")) break;
            System.out.println("Phone number must be 10 or 11 digits.");
        }

        while (true) {
            System.out.print("Are you a student or staff? (s/staff): ");
            role = scanner.nextLine().toLowerCase();
            if (role.equals("s") || role.equals("staff")) break;
            System.out.println("Role must be 's' or 'staff'.");
        }

        User user = role.equals("s") ? new Student(name, email, age, gender, phone)
                                     : new Staff(name, email, age, gender, phone);
        system.registerUser(user);
        System.out.println("User registered successfully.");
    }

    private static void offerRide(Scanner scanner, CarpoolSystem system) {
        if (system.getUsers().isEmpty()) {
            System.out.println("No users registered. Please register a user first.");
            return;
        }

        System.out.println("Registered Users:");
        for (int i = 0; i < system.getUsers().size(); i++) {
            System.out.println(i + ". " + system.getUsers().get(i).name);
        }

        int driverIndex;
        try {
            System.out.print("Select driver index: ");
            driverIndex = Integer.parseInt(scanner.nextLine());
            if (driverIndex < 0 || driverIndex >= system.getUsers().size()) throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            System.out.println("Invalid driver index.");
            return;
        }

        User driver = system.getUsers().get(driverIndex);

        System.out.print("Enter max passengers: ");
        int max = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter pickup point: ");
        String pickup = scanner.nextLine();
        System.out.print("Enter drop point: ");
        String drop = scanner.nextLine();
        System.out.print("Enter pickup time (e.g., 08:00): ");
        String pickupTime = scanner.nextLine();
        System.out.print("Enter drop-off time (e.g., 08:30): ");
        String dropTime = scanner.nextLine();

        System.out.print("Enter vehicle make: ");
        String make = scanner.nextLine();
        System.out.print("Enter vehicle model: ");
        String model = scanner.nextLine();
        System.out.print("Enter vehicle color: ");
        String color = scanner.nextLine();
        System.out.print("Enter license plate: ");
        String plate = scanner.nextLine();
        System.out.print("Enter driver's license number: ");
        String licenseNo = scanner.nextLine();

        Route route = new Route(pickup, drop, pickupTime, dropTime);
        Carpool cp = new Carpool(driver, max, route, make, model, color, plate, licenseNo);
        system.createCarpool(cp);
        System.out.println("Carpool created successfully.");
    }

    private static void joinRide(Scanner scanner, CarpoolSystem system) {
        if (system.getUsers().isEmpty() || system.getCarpools().isEmpty()) {
            System.out.println("Please register users and create carpools first.");
            return;
        }

        System.out.println("Available Users:");
        for (int i = 0; i < system.getUsers().size(); i++) {
            System.out.println(i + ". " + system.getUsers().get(i).name);
        }

        int userIndex;
        try {
            System.out.print("Enter your user index: ");
            userIndex = Integer.parseInt(scanner.nextLine());
            if (userIndex < 0 || userIndex >= system.getUsers().size()) throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            System.out.println("Invalid user index.");
            return;
        }

        User passenger = system.getUsers().get(userIndex);

        System.out.println("Available Carpools:");
        for (int i = 0; i < system.getCarpools().size(); i++) {
            final int index = i;
            System.out.print(index + ". ");
            printBox(() -> system.getCarpools().get(index).offerRide());
        }

        int cpIndex;
        try {
            System.out.print("Enter carpool index to join: ");
            cpIndex = Integer.parseInt(scanner.nextLine());
            if (cpIndex < 0 || cpIndex >= system.getCarpools().size()) throw new IndexOutOfBoundsException();
        } catch (Exception e) {
            System.out.println("Invalid carpool index.");
            return;
        }

        Carpool selectedCarpool = system.getCarpools().get(cpIndex);
        try {
            selectedCarpool.joinRide(passenger);
        } catch (FullCarpoolException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewCarpools(CarpoolSystem system) {
        if (system.getCarpools().isEmpty()) {
            System.out.println("No carpools available.");
        } else {
            for (int i = 0; i < system.getCarpools().size(); i++) {
                final int index = i;
                System.out.print(index + ". ");
                printBox(() -> {
                    Carpool c = system.getCarpools().get(index);
                    c.offerRide();
                    c.showPassengers();
                });
            }
        }
    }

    private static void viewCO2Saved(CarpoolSystem system) {
        for (int i = 0; i < system.getCarpools().size(); i++) {
            final int index = i;
            printBox(() -> {
                Carpool c = system.getCarpools().get(index);
                c.offerRide();
                Carpool.printCO2Report(c);
            });
        }
    }

    private static void printBox(Runnable content) {
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");
        content.run();
        System.out.println("---------------------------------------------------------------------------");
    }
}
