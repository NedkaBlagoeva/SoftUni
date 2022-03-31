package com.example.lab.service;

import com.example.lab.model.dto.EmployeeDto;
import com.example.lab.model.entities.Employee;

public interface EmployeeService {
    EmployeeDto findOne (Long Id);
}
