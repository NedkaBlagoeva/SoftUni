package softuni.exam.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "pictures")
public class Picture extends BaseEntity{

    @Column(unique = true)
    private String name;

    @Column(name = "date_and_time")
    private LocalDate dateAndTime;

    @ManyToOne
    private Car car;

    @ManyToMany(mappedBy = "pictures")
    private Set<Offer> offers;

    public Picture() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(LocalDate dateAndTime) {
        this.dateAndTime = dateAndTime;
    }
}
