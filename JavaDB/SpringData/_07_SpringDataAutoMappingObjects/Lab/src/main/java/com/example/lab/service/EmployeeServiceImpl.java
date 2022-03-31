package com.example.lab.service;

import com.example.lab.model.dto.EmployeeDto;
import com.example.lab.model.entities.Employee;
import com.example.lab.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto findOne(Long id) {

        var employee = employeeRepository.findById(id).orElseThrow();
        var dto = new EmployeeDto();
//        dto.setFirstName(employee.getFirstName());
//        dto.setLastName(employee.getLastName());
//        dto.setSalary(employee.getSalary());
        ModelMapper mapper = new ModelMapper();
        dto = mapper.map(employee, EmployeeDto.class);
        return dto;
    }
}
