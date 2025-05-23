package com.example.accessing_data_mongodb.repository;

import com.example.accessing_data_mongodb.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer,String> {
    Customer findByFirstName(String firstName);
    List<Customer> findByLastName(String lastName);
}
