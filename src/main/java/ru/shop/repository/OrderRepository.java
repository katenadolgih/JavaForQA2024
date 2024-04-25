package ru.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shop.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> { }


//public class OrderRepository {
//
//    List<Order> orders = new ArrayList<>();
//
//    public void save(Order order) {
//        orders.add(order);
//    }
//
//    public List<Order> findAll() {
//        return orders;
//    }
//
//    public Optional<Order> findById(UUID id) {
//        for (Order order : orders) {
//            if (order.getId().equals(id)) {
//                return Optional.of(order);
//            }
//        }
//        return Optional.empty();
//    }
//}
