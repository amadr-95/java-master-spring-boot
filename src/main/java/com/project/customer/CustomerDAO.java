package com.project.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    List<Customer> getAllCustomers();

    Optional<Customer> findById(int id);

    void saveCustomer(Customer customer);

    boolean existCustomerByEmail(String email);

    boolean existCustomerById(int id);

    void deleteById(int id);

    void updateCustomer(Customer customer);
}
