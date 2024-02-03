package com.bascode.service.serviceImpl;

import com.bascode.model.Customer;
import com.bascode.repository.CustomerRepository;
import com.bascode.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepo;
    @Override
    public Customer createNewCustomer(Customer customer){
        customer.getFirstName().trim();
        customer.getLastName().trim();
        return customerRepo.save(customer);
    }

    @Override
    public List<Customer> fetchAllCustomers() {
        return customerRepo.findAll();
    }

    @Override
    public Customer updateCustomer(long id, Customer customer) {
        Customer exitingCustomer = customerRepo
                .findById(id)
                .stream()
                .filter(custId -> custId.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No customer with the id of "+id));

        exitingCustomer.setFirstName(customer.getFirstName());
        exitingCustomer.setLastName(customer.getLastName());
        exitingCustomer.setAge(customer.getAge());
        exitingCustomer.setEmail(customer.getEmail());
        exitingCustomer.setGender(customer.getGender());
        exitingCustomer.setPhone(customer.getPhone());
        exitingCustomer.setState(customer.getState());
        exitingCustomer.setCountry(customer.getCountry());
        exitingCustomer.setCsn(customer.getCsn());
        customerRepo.save(exitingCustomer);
        return exitingCustomer;
    }

    @Override
    public Customer customerById(long id) {
                  customerRepo.findById(id)
                .stream()
                .filter(custId -> custId.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No Customer with id "+id));
        return customerRepo.findById(id).get();
    }

    @Override
    public String deleteById(long id) {
        customerRepo.findById(id)
                .stream()
                .filter(custId -> custId.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such customer with id "+id));
        customerRepo.deleteById(id);
        return "Customer with id of "+id+" successfully deleted";
    }
}
