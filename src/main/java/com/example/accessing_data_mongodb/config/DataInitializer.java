package com.example.accessing_data_mongodb.config;

import com.example.accessing_data_mongodb.model.User;
import com.example.accessing_data_mongodb.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    private final PasswordEncoder passwordEncoder;

    public DataInitializer(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public CommandLineRunner loadInitialData(UserRepository userRepository) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                String hashedPassword = passwordEncoder.encode("admin123");
                User admin = new User("admin", hashedPassword, "ROLE_ADMIN");
                userRepository.save(admin);
                System.out.println("Admin kullanıcısı hash'lenmiş şifreyle MongoDB'ye eklendi.");
            } else {
                System.out.println("Admin kullanıcısı zaten mevcut.");
            }
        };
    }
}

