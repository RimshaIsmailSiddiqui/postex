package com.java.product.services;

import com.java.product.domain.Products;

import java.util.List;

public interface ProductService {
    List<Products> listAll();

    void save(Products product);

    Products get(Integer id);

    void delete(Integer id);
}
