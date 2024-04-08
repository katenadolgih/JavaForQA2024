package ru.shop.service;

import ru.shop.model.Customer;
import ru.shop.repository.CustomerRepository;

import java.util.List;

public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void save(Customer customer){
        repository.save(customer);
    }

    public List<Customer> findAll(){
        return repository.findAll();
    }
}
