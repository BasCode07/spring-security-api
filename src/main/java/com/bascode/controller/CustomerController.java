package com.bascode.controller;

import com.bascode.model.Customer;
import com.bascode.service.serviceImpl.CustomerServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @PostMapping("/create")
    public ResponseEntity<Customer> newCustomer(@RequestBody @Valid Customer customer){
        return new ResponseEntity<>(customerServiceImpl.createNewCustomer(customer),
                HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> fetchAll(){
        return ResponseEntity.ok(customerServiceImpl.fetchAllCustomers());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody @Valid Customer customer){
        return ResponseEntity.ok(customerServiceImpl.updateCustomer(id, customer));
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<Customer> fetchCustomerById(@PathVariable("id") long id){
        return ResponseEntity.ok(customerServiceImpl.customerById(id));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable("id") long id){
        return ResponseEntity.ok(customerServiceImpl.deleteById(id));
    }
}
