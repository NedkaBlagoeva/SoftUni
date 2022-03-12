package com.example.advquerying;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.services.IngredientService;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class Main implements CommandLineRunner {

    Scanner scan = new Scanner(System.in);
    private final ShampooService shampooService;
    private final IngredientService ingredientService;

    public Main(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }


    @Override
    public void run(String... args) {

        // task1();
        // task2();
        // task3();
        // task4();
        // task5();
        // task6();
        // task7();
        // task8();
        // task9();
        // task10();
        task11();


    }

    private void task11() {
        System.out.println("Enter ingredient name: ");
        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).toList();
        ingredientService
                .updatePriceByName(names);
        System.out.println("Success!");
    }

    private void task10() {
        ingredientService
                .updatePrice();
        System.out.println("Success!");
    }

    private void task9() {
        System.out.println("Enter ingredient name: ");
        String name = scan.nextLine();
        ingredientService.deleteIngredientByName(name);
        System.out.println("Success!");
    }

    private void task8() {
        System.out.println("Enter number of ingredients: ");
        int number = Integer.parseInt(scan.nextLine());
        shampooService
                .findAllByTheNumberOfIngredientsLessThan(number)
                .stream().map(Shampoo::getBrand)
                .forEach(System.out::println);
    }

    private void task7() {
        System.out.println("Enter ingredients names: ");
        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).toList();
        shampooService
                .findAllByIngredientsIncluded(names)
                .stream().map(Shampoo::getBrand).distinct()
                .forEach(System.out::println);
    }

    private void task6() {
        System.out.println("Enter price: ");
        BigDecimal price = new BigDecimal(scan.nextLine());
        System.out.println(shampooService.findAllByPriceLessThanCount(price));
    }

    private void task5() {
        System.out.println("Enter list: ");
        List<String> names = Arrays.stream(scan.nextLine().split("\\s+")).toList();
        ingredientService
                .findAllByNameInOrderByPrice(names)
                .stream().map(Ingredient::getName)
                .forEach(System.out::println);
    }

    private void task4() {
        System.out.println("Enter letters: ");
        String letters = scan.nextLine();
        ingredientService
                .findAllByNameStartingWith(letters)
                .stream().map(Ingredient::getName)
                .forEach(System.out::println);
    }

    private void task3() {
        System.out.println("Enter price: ");
        BigDecimal price = scan.nextBigDecimal();
        shampooService
                .findAllByPriceGreaterThanOrderByPriceDesc(price)
                .forEach(System.out::println);
    }

    private void task2() {

        System.out.println("Enter size (SMALL, MEDIUM, LARGE): ");
        Size size = Size.valueOf(scan.nextLine());
        System.out.println("Enter label ID");
        Long labelId = Long.parseLong(scan.nextLine());
        shampooService
                .findAllBySizeOrLabel_IdOrderByPrice(size, labelId)
                .forEach(System.out::println);
    }

    private void task1() {
        System.out.println("Enter size (SMALL, MEDIUM, LARGE): ");
        Size size = Size.valueOf(scan.nextLine());
        shampooService
                .findAllBySizeOrderById(size)
                .forEach(System.out::println);
    }
}
