package bg.softuni.coffeeshop.web;

import bg.softuni.coffeeshop.model.binding.OrderAddBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/add")
    public String add() {
        return "order-add";
    }

    @PostMapping("/add")
    public String postAdd(@Valid OrderAddBindingModel orderAddBindingModel, BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {
        if(bindingResult.hasErrors()){
            redirectAttributes
                    .addFlashAttribute("orderAddBindingModel", orderAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.orderAddBindingModel", bindingResult);
            return "redirect:add";
        }


        return "redirect:/";
    }

    @ModelAttribute
    public OrderAddBindingModel orderAddBindingModel(){
        return new OrderAddBindingModel();
    }
}
