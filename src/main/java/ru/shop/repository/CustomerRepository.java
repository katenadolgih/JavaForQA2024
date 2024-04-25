package ru.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shop.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> { }


//public class CustomerRepository {
//
//    List<Customer> customers = new ArrayList<>();
//
//    public void save(Customer customer) {
//        customers.add(customer);
//    }
//
//    public List<Customer> findAll() {
//        return customers;
//    }
//
//    public Optional<Customer> findById(UUID id) {
//        for (Customer customer : customers) {
//            if (customer.getId().equals(id)) {
//                return Optional.of(customer);
//            }
//        }
//        return Optional.empty();
//    }
//}
