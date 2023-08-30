package com.project.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerDataAccessService implements CustomerDAO {

    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>(List.of(
                new Customer(1, "Alex", "alex@gmail.com", 25),
                new Customer(2, "Jamila", "jamila@gmail.com", 18)
        ));
    }

    @Override
    public List<Customer> getAllCustomers() {
            return customers;
    }

    @Override
    public Optional<Customer> findById(int customerId) {
        return customers.stream()
                .filter(customer -> customer.getId() == customerId)
                .findFirst();
    }
}
