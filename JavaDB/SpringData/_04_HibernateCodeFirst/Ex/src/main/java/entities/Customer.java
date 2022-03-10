package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "customers")
public class Customer extends BaseEntity {

    private String name;

    @Column (unique = true, nullable = false)
    private String email;

    @Column (name = "credit_card_number")
    private String creditCardNumber;

    @OneToMany (targetEntity = Sale.class, mappedBy = "customer")
    private Set<Sale> sales;

    public Customer() {
        this.sales = new HashSet<>();
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Set<Sale> getSales() {
        return sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCredit_card_number() {
        return creditCardNumber;
    }

    public void setCredit_card_number(String credit_card_number) {
        this.creditCardNumber = credit_card_number;
    }
}
