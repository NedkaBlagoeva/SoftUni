package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "countries")
public class Country extends BaseEntity{

    @Column(name = "country_name", nullable = false, unique = true)
    private String countryName;

    @Column(nullable = false)
    private String currency;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
