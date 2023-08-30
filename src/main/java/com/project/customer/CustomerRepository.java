package com.project.customer;

import org.springframework.data.jpa.repository.JpaRepository;

//no need to be annotated with @Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    boolean existCustomerByEmail(String email);
}
