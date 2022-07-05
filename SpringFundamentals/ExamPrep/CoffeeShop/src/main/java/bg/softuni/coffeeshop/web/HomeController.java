package bg.softuni.coffeeshop.web;

import bg.softuni.coffeeshop.model.view.OrderViewModel;
import bg.softuni.coffeeshop.service.OrderService;
import bg.softuni.coffeeshop.service.UserService;
import bg.softuni.coffeeshop.temp.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final OrderService orderService;
    private final UserService userService;

    public HomeController(CurrentUser currentUser, OrderService orderService, UserService userService) {
        this.currentUser = currentUser;
        this.orderService = orderService;
        this.userService = userService;
    }


    @GetMapping()
    public String index(Model model) {
        if (currentUser.getId() == null) {
            return "index";
        }

        List<OrderViewModel> orders = orderService.findAllByPriceDesc();
        model.addAttribute("orders",orders );
        model.addAttribute("totalTime", orders.stream()
                .mapToInt(o -> o.getCategory().getNeededTime()).sum());
        model.addAttribute("users", userService.findAllByOrdersSizeDesc());

        return "home";
    }

//    @GetMapping("/home")
//    public String home() {
//        return "home";
//    }
}
