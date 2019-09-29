package HomeWork;

public class Person {
    private String first_name;
    private String phone;
    private String email;

    Person(String name, String phone, String email){
        this.first_name = name;
        this.phone = phone;
        this.email = email;
    }

    String getFirst_name() {
        return first_name;
    }

    String getPhone() {
        return phone;
    }

    String getEmail() {
        return email;
    }
}
