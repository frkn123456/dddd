package com.example.accessing_data_mongodb.repository;

import com.example.accessing_data_mongodb.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByUsername(String username); // Kullancıyı kullancı adına göre bulmak için
}
