package bg.softuni.coffeeshop.repository;

import bg.softuni.coffeeshop.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
