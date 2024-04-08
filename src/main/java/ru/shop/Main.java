package ru.shop;

import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.ProductRepository;

import java.util.UUID;

import static ru.shop.model.ProductType.GOOD;
import static ru.shop.model.ProductType.SERVICE;

public class Main {
    public static void main(String[] args) {

        CustomerRepository customerRepository=new CustomerRepository();
        ProductRepository productRepository=new ProductRepository();
        OrderRepository orderRepository=new OrderRepository();


        System.out.println(ProductType.SERVICE.name());

        Product ladaKalina=new Product(UUID.randomUUID(), "Lada Kalina", 100, GOOD);
        productRepository.save(ladaKalina);
//        System.out.println(ladaKalina);

        Product hondaCRV=new Product(UUID.randomUUID(), "Honda CRV", 150, GOOD);
        productRepository.save(hondaCRV);
        Product carWashing=new Product(UUID.randomUUID(), "Car Washing", 150, SERVICE);
        productRepository.save(carWashing);

        Customer ivan =new Customer(UUID.randomUUID(), "Ivanushka", "123456", 16);
        customerRepository.save(ivan);
        Customer mishel =new Customer(UUID.randomUUID(), "Mishel", "654321", 20);
        customerRepository.save(mishel);

        Order order1= new Order(UUID.randomUUID(),ivan.getId(),ladaKalina.getId(), 2,100);
        orderRepository.save(order1);
        Order order2= new Order(UUID.randomUUID(),mishel.getId(),hondaCRV.getId(), 1,150);
        orderRepository.save(order2);

        //Print
        for (Customer customer:customerRepository.findAll()){
            System.out.println(customer);
        }

        for (Order order:orderRepository.findAll()){
            System.out.println(order);
        }

        for (Product product:productRepository.findAll()){
            System.out.println(product);
        }
    }


}