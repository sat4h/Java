package com.example.demo.services;

public interface IService<T> {
    Iterable<T> all();

    T add(T entity);

    void delete(T entity);

    void edit(T entity);

    T getById(int id);
}
