package softuni.exam.instagraphlite.models.entity;

import org.springframework.util.comparator.Comparators;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;

@Entity(name = "users")
public class User extends BaseEntity{

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne(optional = false)
    private Picture picture;

    @OneToMany(mappedBy = "user")
    private Set<Post> posts;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return String.format("User: %s\n" +
                "Post count: %d\n"
                , username, posts.size(),
                posts
                .forEach(p -> System.out.printf("""
                        ==Post Details:
                        ----Caption: %s
                        ----Picture Size: %.2f
                        
                        """, p.getCaption(), p.getPicture().getSize())));
    }
}
