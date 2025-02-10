package com.customerManagementSystem.service;
//CustomerService.java (Business Logic Layer)


import com.customerManagementSystem.models.Customer;
import com.customerManagementSystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
 
 @Autowired
 private CustomerRepository customerRepository;

 // Retrieve all customers
 public List<Customer> getAllCustomers() {
     return customerRepository.findAll();
 }

 // Retrieve a customer by ID
 public Optional<Customer> getCustomerById(Long id) {
     return customerRepository.findById(id);
 }

 // Create a new customer
 public Customer createCustomer(Customer customer) {
     return customerRepository.save(customer);
 }

 // Update an existing customer
 public Customer updateCustomer(Long id, Customer customerDetails) {
     Customer customer = customerRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));

     customer.setName(customerDetails.getName());
     customer.setEmail(customerDetails.getEmail());
     customer.setPhoneNumber(customerDetails.getPhoneNumber());

     return customerRepository.save(customer);
 }

 // Delete a customer
 public void deleteCustomer(Long id) {
     Customer customer = customerRepository.findById(id)
             .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
     customerRepository.delete(customer);
 }
}

