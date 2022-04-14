package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.ImportCustomerDto;
import exam.model.entity.Customer;
import exam.repository.CustomerRepository;
import exam.service.CustomerService;
import exam.service.TownService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CustomerServiceImpl implements CustomerService {

    public static final String CUSTOMERS_FILE_PATH = "src/main/resources/files/json/customers.json";

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;
    private final TownService townService;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson, TownService townService) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMERS_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        ImportCustomerDto[] importCustomerDtos = gson.fromJson(readCustomersFileContent(), ImportCustomerDto[].class);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(importCustomerDtos).forEach(importCustomerDto -> {
            if (validationUtil.isValid(importCustomerDto)) {
                Customer customer = modelMapper.map(importCustomerDto, Customer.class);
                if (customerRepository.findByEmail(customer.getEmail()).isEmpty()) {
                    customer.setTown(townService.findByName(importCustomerDto.getTown().getName()).get());
                    customerRepository.save(customer);
                    sb.append(String.format("Successfully imported Customer %s %s - %s",
                            customer.getFirstName(), customer.getLastName(), customer.getEmail()));
                } else {
                    sb.append("Invalid customer");
                }
            } else {
                sb.append("Invalid customer");
            }
            sb.append(System.lineSeparator());
        });
        return sb.toString();
    }
}
