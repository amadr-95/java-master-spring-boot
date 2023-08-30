package com.project.customer;

import com.project.exception.DuplicateResourceException;
import com.project.exception.ResourceNotFoundException;
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
                .orElseThrow(() -> new ResourceNotFoundException("customer with id [%s] does not exist".formatted(customerId)));
    }

    public void saveCustomer(Customer customer) {
        //check if email already exist
        if(customerDAO.existCustomerByEmail(customer.getEmail()))
            throw new DuplicateResourceException("email already exist");
        customerDAO.saveCustomer(customer);
    }

    public void deleteCustomer(int customerId) {
        //check if customer exists
        //findById(customerId);
        if(!customerDAO.existCustomerById(customerId))
            throw new ResourceNotFoundException("customer with id [%s] does not exist".formatted(customerId));
        customerDAO.deleteById(customerId);
    }
}
