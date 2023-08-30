package com.project.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    List<Customer> getAllCustomers();

    Optional<Customer> findById(int id);
}
