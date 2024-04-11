package ru.shop;

import ru.shop.exception.BadOrderCountException;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.ProductRepository;
import ru.shop.service.CustomerService;
import ru.shop.service.OrderService;
import ru.shop.service.ProductService;

import java.util.UUID;

import static ru.shop.model.ProductType.GOOD;
import static ru.shop.model.ProductType.SERVICE;

public class Main {
    public static void main(String[] args) {

        ProductService productService=new ProductService(
                new ProductRepository()
        );
        CustomerService customerService=new CustomerService(
                new CustomerRepository()
        );
        OrderService orderService=new OrderService(
                new OrderRepository()
        );

//        CustomerRepository customerRepository=new CustomerRepository();
//        ProductRepository productRepository=new ProductRepository();
//        OrderRepository orderRepository=new OrderRepository();


        System.out.println(ProductType.SERVICE.name());

        Product ladaKalina=new Product(UUID.randomUUID(), "Lada Kalina", 100, GOOD);
        productService.save(ladaKalina);
//        System.out.println(ladaKalina);

        Product hondaCRV=new Product(UUID.randomUUID(), "Honda CRV", 150, GOOD);
        productService.save(hondaCRV);
        Product carWashing=new Product(UUID.randomUUID(), "Car Washing", 150, SERVICE);
        productService.save(carWashing);

        Customer ivan =new Customer(UUID.randomUUID(), "Ivanushka", "123456", 16);
        customerService.save(ivan);
        Customer mishel =new Customer(UUID.randomUUID(), "Mishel", "654321", 20);
        customerService.save(mishel);



 //       Order order1= new Order(UUID.randomUUID(),ivan.getId(),ladaKalina.getId(), 2,100);
        orderService.add(ivan,ladaKalina, 2);
        orderService.add(ivan,carWashing, 5);
//        Order order2= new Order(UUID.randomUUID(),mishel.getId(),hondaCRV.getId(), 1,150);
        try {
            orderService.add(mishel,hondaCRV, 0);
        } catch (BadOrderCountException ex){
            System.out.println("BadOrderCountException");
        }


        System.out.println(orderService.findByCustomer(ivan));
        System.out.println(orderService.getTotalCustomerAmount(ivan));

        System.out.println("---Ivan's orders");
        for (Order order: orderService.findByCustomer(ivan)){
            System.out.println(order);
        }
//        //Print
//        for (Customer customer:customerRepository.findAll()){
//            System.out.println(customer);
//        }
//
//        for (Order order:orderRepository.findAll()){
//            System.out.println(order);
//        }
//
//        for (Product product:productRepository.findAll()){
//            System.out.println(product);
//        }
    }


}