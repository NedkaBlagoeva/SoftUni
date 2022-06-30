package bg.softuni.coffeeshop.service;

import bg.softuni.coffeeshop.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


}
