package com.ecommerce.ProductService.service;

import com.ecommerce.ProductService.entities.Product;
import com.ecommerce.ProductService.entities.ProductCatalog;
import com.ecommerce.ProductService.entities.ProductCategory;
import com.ecommerce.ProductService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product){
        product.setProductStatus("success");
        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    public List<Product> getAllProducts(){
        List<Product> listOfProducts = productRepository.findAll();
        return listOfProducts;
    }


}
