package com.project;

import com.project.customer.Customer;
import com.project.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customers = new ArrayList<>(List.of(
                    new Customer(1, "Alex", "alex@gmail.com", 25),
                    new Customer(2, "Jamila", "jamila@gmail.com", 18)
            ));
            customerRepository.saveAll(customers);
        };
    }
}
