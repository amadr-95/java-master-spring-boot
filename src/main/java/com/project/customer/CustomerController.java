package com.project.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //@GetMapping("api/v1/customer") = @RequestMapping(path = "api/v1/customer", method = RequestMethod.GET)
    @GetMapping("api/v1/customers")
    public List<Customer> getAllCostumers() {
        return customerService.getAllCostumers();
    }

    @GetMapping("api/v1/customers/{customerId}")
    public Customer findById(@PathVariable(name = "customerId") int customerId) {
        return customerService.findById(customerId);
    }
}
