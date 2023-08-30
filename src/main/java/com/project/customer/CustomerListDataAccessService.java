package com.project.customer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Qualifier("list")
public class CustomerListDataAccessService implements CustomerDAO {

    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>(List.of(
                new Customer(1, "Alex", "alex@gmail.com", 25),
                new Customer(2, "Jamila", "jamila@gmail.com", 18)
        ));
    }

    @Override
    public List<Customer> getAllCostumers() {
            return customers;
    }

    @Override
    public Optional<Customer> findById(int customerId) {
        return customers.stream()
                .filter(customer -> customer.getId() == customerId)
                .findFirst();
    }
}
