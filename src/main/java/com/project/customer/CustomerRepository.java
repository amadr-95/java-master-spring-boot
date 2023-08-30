package com.project.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//no need to be annotated with @Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.email = ?1")
    boolean existCustomerByEmail(String email);
}
