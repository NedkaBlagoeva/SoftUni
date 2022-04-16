package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.instagraphlite.models.Post;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
