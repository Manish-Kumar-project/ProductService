package com.ecommerce.ProductService.controller;

import com.ecommerce.ProductService.entities.Product;
import com.ecommerce.ProductService.entities.ProductCatalog;
import com.ecommerce.ProductService.entities.ProductCategory;
import com.ecommerce.ProductService.model.v1.ProductOverviewModel;
import com.ecommerce.ProductService.model.v1.SearchCriteriaBaseModel;
import com.ecommerce.ProductService.repository.ProductRepository;
import com.ecommerce.ProductService.repository.impl.ProductCategoryImplementation;
import com.ecommerce.ProductService.service.ProductService;
import com.ecommerce.ProductService.service.serviceimpl.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductCategoryImplementation productCategoryImplementation;

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
    @GetMapping(value = "/productcategories")
    public ResponseEntity<SearchCriteriaBaseModel> getProductCategoriesList() {
        SearchCriteriaBaseModel searchCriteriaBaseModel = productCategoryService.getProductCategoriesList();
        return new ResponseEntity<SearchCriteriaBaseModel>(searchCriteriaBaseModel,HttpStatus.OK);
    }
    @GetMapping(value = "/productcatalog")
    public ResponseEntity<SearchCriteriaBaseModel> getProductCatalogList() {
        SearchCriteriaBaseModel searchCriteriaBaseModel = productCategoryService.getProductCatalogList();
        return new ResponseEntity<SearchCriteriaBaseModel>(searchCriteriaBaseModel,HttpStatus.OK);
    }
    @GetMapping(value = "/product-detail/{id}")
    public ResponseEntity<ProductOverviewModel> getProductOverview(@PathVariable Integer id) {
        ProductOverviewModel productOverviewModel = new ProductOverviewModel();
        productOverviewModel = productCategoryService.getProductOverview(id);
        return new ResponseEntity<ProductOverviewModel>(productOverviewModel,HttpStatus.OK);
    }
    }
