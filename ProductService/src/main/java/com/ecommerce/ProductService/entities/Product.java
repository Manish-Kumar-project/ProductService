package com.ecommerce.ProductService.entities;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private Integer productId;
    private String productName;
    private String productCode;
    private String productUniqueId;
    private String productStatus;

    public Product() {
    }

    public Product(Integer id, Integer productId, String productName, String productCode, String productUniqueId, String productStatus) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.productCode = productCode;
        this.productUniqueId = productUniqueId;
        this.productStatus = productStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductUniqueId() {
        return productUniqueId;
    }

    public void setProductUniqueId(String productUniqueId) {
        this.productUniqueId = productUniqueId;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }
}
