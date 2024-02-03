package com.bascode.service;

import com.bascode.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer createNewCustomer(Customer customer);
    public List<Customer> fetchAllCustomers();
    public Customer updateCustomer(long id, Customer customer);
    public Customer customerById(long id);
    public String deleteById(long id);
}
