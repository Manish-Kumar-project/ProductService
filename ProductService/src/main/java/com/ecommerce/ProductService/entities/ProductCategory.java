package com.ecommerce.ProductService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryId")
    private Long categoryId;
    @Column(name="category_unique_id", length=20, nullable=false, unique=true)
    private Long categoryUniqueId;
    @Column(name="category_name", length=40, nullable=false, unique=false)
    private String categoryName;
    @Column(name="category_quantity", length=10, nullable=false, unique=false)
    private Integer categoryQuantity;

    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductCatalog> productCatalogs = new ArrayList<>();


}
