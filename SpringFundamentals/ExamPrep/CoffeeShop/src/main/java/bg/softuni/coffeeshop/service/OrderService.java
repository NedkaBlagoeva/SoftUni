package bg.softuni.coffeeshop.service;

import bg.softuni.coffeeshop.model.entity.Order;
import bg.softuni.coffeeshop.model.service.OrderServiceModel;
import bg.softuni.coffeeshop.model.view.OrderViewModel;
import bg.softuni.coffeeshop.repository.OrderRepository;
import bg.softuni.coffeeshop.temp.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final CategoryService categoryService;

    public OrderService(OrderRepository orderRepository, ModelMapper modelMapper, UserService userService, CurrentUser currentUser, CategoryService categoryService) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
        this.currentUser = currentUser;
        this.categoryService = categoryService;
    }


    public void addOrder(OrderServiceModel orderServiceModel) {
        Order order = modelMapper.map(orderServiceModel, Order.class);
                order.setEmployee(userService.findById(currentUser.getId()));
                order.setCategory(categoryService.findByCategoryName(orderServiceModel.getCategory()));

                orderRepository.save(order);
    }

    public List<OrderViewModel> findAllByPriceDesc() {
        return orderRepository
               .getAllByOrderByPriceDesc()
                .stream()
                .map(order -> modelMapper.map(order, OrderViewModel.class))
                .collect(Collectors.toList());
    }
}
