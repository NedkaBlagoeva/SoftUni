package bg.softuni.coffeeshop.repository;

import bg.softuni.coffeeshop.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryRepository extends JpaRepository<Category, Long> {
}
