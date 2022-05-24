package softuni.exam.instagraphlite.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "pictures")
public class Picture extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String path;

    @Column(nullable = false)
    private double size;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
