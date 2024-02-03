package com.bascode.model;

import com.bascode.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandLine implements CommandLineRunner {

    @Autowired
    private CustomerRepository repo;
    @Override
    public void run(String... args) throws Exception {
        Customer customer = new Customer();
        customer.setFirstName("Bakare");
        customer.setLastName("Samson");
        customer.setAge(35);
        customer.setGender('M');
        customer.setEmail("samson@gmail.com");
        customer.setPhone("8161376235");
        customer.setState("Lagos");
        customer.setCountry("Nigeria");
        customer.setCsn(457721);

        Customer customer1 = new Customer();
        customer1.setFirstName("Bakare");
        customer1.setLastName("Abiodun");
        customer1.setAge(36);
        customer1.setGender('M');
        customer1.setEmail("abiodun@gmail.com");
        customer1.setPhone("8161376276");
        customer1.setState("Ogun");
        customer1.setCountry("Nigeria");
        customer1.setCsn(457767);

        Customer customer2 = new Customer();
        customer2.setFirstName("Owoseni");
        customer2.setLastName("Tunde");
        customer2.setAge(45);
        customer2.setGender('M');
        customer2.setEmail("tunde@gmail.com");
        customer2.setPhone("8156376235");
        customer2.setState("Lagos");
        customer2.setCountry("USA");
        customer2.setCsn(767721);

        List<Customer> customersList = List.of(customer,customer1,customer2);
        repo.saveAll(customersList);




    }
}
