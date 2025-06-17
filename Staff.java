public class Staff extends User {

    public Staff(String name, String email, int age, String gender, String phone) {
        super(name, email, age, gender, phone);
    }

    @Override
    public void displayInfo() {
        System.out.println("[STAFF] Name: " + name + 
                           ", Age: " + age + 
                           ", Gender: " + gender +
                           ", Phone: " + phoneNumber + 
                           ", Email: " + email);
    }
}
