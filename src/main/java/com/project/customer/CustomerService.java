package com.project.customer;

import com.project.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDAO customerDAO;

    public CustomerService(@Qualifier("jpa") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public List<Customer> getAllCostumers() {
        return customerDAO.getAllCustomers();
    }

    public Customer findById(int customerId) {
        return customerDAO.findById(customerId)
                .orElseThrow(() -> new ResourceNotFound("customer with id [%s] does not exist".formatted(customerId)));
    }
}
