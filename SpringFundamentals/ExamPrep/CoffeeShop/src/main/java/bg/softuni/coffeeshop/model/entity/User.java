package bg.softuni.coffeeshop.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    @Column(unique = true, nullable = false)
    private String Username;

    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;


    //•	Has a Username (unique)
        //o	The length of the username must be between 5 and 20 characters (both numbers are INCLUSIVE).
    //•	Has a First Name
        //o	Can be null.
    //•	Has a Last Name
        //o	The length of the last name must be between 5 and 20 characters (both numbers are INCLUSIVE).
    //•	Has a Password
        //o	The length of the password must be more than 3 (INCLUSIVE).
    //•	Has an Email
        //o	Must contain a '@' symbol.
        //o	The email must be unique.


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
