package com.java.product.controller;

import com.java.product.domain.Products;
import com.java.product.services.ProductService;
import com.java.product.services.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {

    public final ProductService productService;
    @Autowired
    public ProductController(ProductServiceImpl productService)
    {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Products> list() {
        return productService.listAll();
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Products> get(@PathVariable Integer id) {
        try {
            Products product = productService.get(id);
            return new ResponseEntity<Products>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Products>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/products")
    public void add(@RequestBody Products product) {
        productService.save(product);
    }
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
    }
    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@RequestBody Products product, @PathVariable Integer id) {
        try {
            Products existProduct = productService.get(id);
            productService.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

