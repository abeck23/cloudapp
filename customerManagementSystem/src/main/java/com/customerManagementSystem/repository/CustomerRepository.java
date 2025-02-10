package com.customerManagementSystem.repository;
//CustomerRepository.java (Data Access Layer)


import com.customerManagementSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
 // Additional query methods can be defined here if needed
}

