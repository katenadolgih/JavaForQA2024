package ru.shop.service;

import ru.shop.model.Customer;

import java.util.List;

public interface IService<T> {
    void save(T entity);

    List<T> findAll();
}
