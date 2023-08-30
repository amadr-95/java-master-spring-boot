package com.project.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //@GetMapping("api/v1/customer") = @RequestMapping(path = "api/v1/customer", method = RequestMethod.GET)
    @GetMapping
    public List<Customer> getAllCostumers() {
        return customerService.getAllCostumers();
    }

    @GetMapping("{customerId}")
    public Customer findById(@PathVariable(name = "customerId") int customerId) {
        return customerService.findById(customerId);
    }

    @PostMapping
    public void saveCustomer(@RequestBody Customer customer) {
        customerService.saveCustomer(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable(name = "customerId") int customerId) {
        customerService.deleteCustomer(customerId);
    }

    @PutMapping("{customerId}")
    public void updateCustomer(
            @PathVariable(name = "customerId") int customerId,
            @RequestBody Customer customer
    ) {
        customerService.updateCustomer(customerId, customer);
    }
}
