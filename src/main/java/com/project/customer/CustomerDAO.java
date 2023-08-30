package com.project.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    List<Customer> getAllCostumers();

    Optional<Customer> findById(int id);

    void saveCustomer(Customer customer);
}
