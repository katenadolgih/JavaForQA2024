package ru.shop.service;

import ru.shop.exception.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.repository.IRepository;
import ru.shop.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService{
    private final IRepository<Order> repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public void add(Customer customer, Product product, long count){
        if (count<=0){
            throw new BadOrderCountException();
        }
        Order order = new Order(UUID.randomUUID(), customer.getId(), product.getId(), count, product.getCost()*count);
        repository.save(order);
    }

    public List<Order> findByCustomer(Customer customer){
        List<Order> result =new ArrayList<>();
        for (Order order:repository.findAll()){
            if (order.getCustomerId()==customer.getId()){
                result.add(order);
            }
        }
        return result;
    }

    //* добавить метод (getTotalCustomerAmount) подсчёта суммы для оплаты для пользователя
    public long getTotalCustomerAmount(Customer customer){
        long result=0;
        for (Order order:findByCustomer(customer)){
            result=+order.getAmount();
        }
        return result;
    }

    public List<Order> findAll(){
        return repository.findAll();
    }

}
