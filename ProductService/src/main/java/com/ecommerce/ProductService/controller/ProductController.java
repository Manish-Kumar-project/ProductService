package com.ecommerce.ProductService.controller;

import com.ecommerce.ProductService.entities.Product;
import com.ecommerce.ProductService.entities.ProductCatalog;
import com.ecommerce.ProductService.entities.ProductCategory;
import com.ecommerce.ProductService.repository.ProductRepository;
import com.ecommerce.ProductService.service.ProductService;
import com.ecommerce.ProductService.service.serviceimpl.ProductCategoryService;
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

    @Autowired
    private ProductCategoryService productCategoryService;



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

    @PostMapping(value = "/add/product")
    public ProductCategory saveCustomer(@RequestBody ProductCategory productCategory){
        productCategoryService.saveMember(productCategory);
        return productCategory;

    }
    @PostMapping(value = "/productcatalog")
    public void configureProductIndividual(@RequestBody List<ProductCatalog> productCatalogs){
        productCategoryService.configureProductIndividual(productCatalogs);

    }
    @GetMapping(value = "/productcatagories")
    public ResponseEntity<List<ProductCategory>> getAllProductCategories(){
        List<ProductCategory> allproducts = productCategoryService.getAllProductCategories();
        return new ResponseEntity<List<ProductCategory>>(allproducts,HttpStatus.OK);
    }
}
