package softuni.exam.instagraphlite.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "posts")
public class Post extends BaseEntity{

    @Column(nullable = false)
    private String caption;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Picture picture;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
