public abstract class User {
    protected String name;
    protected String email;
    protected int age;
    protected String gender;
    protected String phoneNumber;

    public User(String name, String email, int age, String gender, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public abstract void displayInfo();
}
