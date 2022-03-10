package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "store_location")
public class StoreLocation extends BaseEntity{

    @Column (name = "location_name")
    private String locationName;

    @OneToMany(targetEntity = Sale.class, mappedBy = "storeLocation")
    private Set<Sale> sales;

    public StoreLocation() {
        this.sales = new HashSet<>();
    }

    public String getLocation_name() {
        return locationName;
    }

    public void setLocation_name(String location_name) {
        this.locationName = location_name;
    }
}
