package softuni.exam.instagraphlite.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import softuni.exam.instagraphlite.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
