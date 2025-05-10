package com.example.accessing_data_mongodb;

import com.example.accessing_data_mongodb.model.Customer;
import com.example.accessing_data_mongodb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll(); // Veritabanını temizle

		// Yeni müşteri ekle
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// Tüm müşterileri listele
		System.out.println("Tüm müşteriler:");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}

		// İsme göre sorgu
		System.out.println("\nAdı Alice olan:");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("\nSoyadı Smith olanlar:");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
	}
}

