package com.example.lab;

import com.example.lab.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Main implements CommandLineRunner {

    private final EmployeeService employeeService;


    public Main(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {

        var employDto = employeeService.findOne(1L);
        System.out.println(employDto);
    }
}
