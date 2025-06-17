public class Student extends User {

    public Student(String name, String email, int age, String gender, String phone) {
        super(name, email, age, gender, phone);
    }

    @Override
    public void displayInfo() {
        System.out.println("[STUDENT] Name: " + name + 
                           ", Age: " + age + 
                           ", Gender: " + gender +
                           ", Phone: " + phoneNumber + 
                           ", Email: " + email);
    }
}
