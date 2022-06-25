package bg.softuni.coffeeshop.repository;

import bg.softuni.coffeeshop.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
