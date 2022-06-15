package com.java.product.services.impl;

import com.java.product.domain.Products;
import com.java.product.repository.ProductRepository;
import com.java.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    @Autowired
    ProductServiceImpl(ProductRepository repository){
        this.repository=repository;
    }

    @Override
    public List<Products> listAll() {
        return repository.findAll();
    }

    @Override
    public void save(Products product) {
        repository.save(product);
    }
    @Override
    public Products get(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

}

