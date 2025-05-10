package com.example.accessing_data_mongodb.controller;

import com.example.accessing_data_mongodb.model.Customer;
import com.example.accessing_data_mongodb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerRepository repository;

    @Autowired
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    @GetMapping("/firstname/{name}")
    public Customer getByFirstName(@PathVariable String name) {
        return repository.findByFirstName(name);
    }

    public Customer addCustomer(@RequestBody Customer customer) {
        return repository.save(customer);
    }


}
