package com.customerManagementSystem.controllers;
//CustomerController.java (REST API Layer)


import com.customerManagementSystem.models.Customer;
import com.customerManagementSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;


import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

 OrdersBusinessInterface service;
	Logger logger = LoggerFactory.getLogger(CustomerController.class);
 
 @Autowired
 private CustomerService customerService;

 // GET all customers
 @GetMapping
 public List<Customer> getAllCustomers() {
     return customerService.getAllCustomers();
 }

 // GET customer by ID
 @GetMapping("/{id}")
 public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
     return customerService.getCustomerById(id)
             .map(ResponseEntity::ok)
             .orElse(ResponseEntity.notFound().build());
 }

 // POST create new customer
 @PostMapping
 public Customer createCustomer(@RequestBody Customer customer) {

     //Log the API call
		   logger.info("Entering UserController.addUser()");
     return customerService.createCustomer(customer);
 }

 // PUT update existing customer
 @PutMapping("/{id}")
 public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
     try {
         Customer updatedCustomer = customerService.updateCustomer(id, customerDetails);
         return ResponseEntity.ok(updatedCustomer);
     } catch (RuntimeException e) {
         return ResponseEntity.notFound().build();
     }
 }

 // DELETE customer
 @DeleteMapping("/{id}")
 public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
     try {
         customerService.deleteCustomer(id);
         return ResponseEntity.noContent().build();
     } catch (RuntimeException e) {
         return ResponseEntity.notFound().build();
     }
 }
} 

