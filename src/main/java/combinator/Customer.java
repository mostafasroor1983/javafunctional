package combinator;

import java.time.LocalDate;

public class Customer {
    private String name;
    private String phone;
    private String email;
    private LocalDate dob;

    public Customer(String name, String phone, String email, LocalDate dob) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }
}
