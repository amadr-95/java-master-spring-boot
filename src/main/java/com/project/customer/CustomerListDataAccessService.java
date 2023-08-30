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
    private static int id;

    static {
        customers = new ArrayList<>(List.of(
                new Customer(1, "Alex", "alex@gmail.com", 25),
                new Customer(2, "Jamila", "jamila@gmail.com", 18)
        ));
        id = 2;
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

    @Override
    public void saveCustomer(Customer customer) {
        customer.setId(++id);
        customers.add(customer);
    }

    @Override
    public boolean existCustomerByEmail(String email) {
        return customers.stream()
                .anyMatch(customer -> customer.getEmail().equals(email));
    }
}
