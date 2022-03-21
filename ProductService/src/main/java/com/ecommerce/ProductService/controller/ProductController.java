package com.ecommerce.ProductService.controller;

import com.ecommerce.ProductService.entities.Product;
import com.ecommerce.ProductService.repository.ProductRepository;
import com.ecommerce.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;



    @PostMapping(value = "/product")
    public ResponseEntity<Product> saveCustomer(@RequestBody Product product){
        Product products = productService.addProduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);

    }

    @GetMapping(value = "/products")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> allproducts = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(allproducts,HttpStatus.OK);
    }
}
