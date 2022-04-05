package com.ecommerce.ProductService.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productcatalogId")
    private Long productCatalogId;

    @Column(name="product_catalog_name", length=50, nullable=false, unique=false)
    private String productCatalogName;

    @Column(name="product_catalog_type", length=50, nullable=false, unique=false)
    private String productCatalogType;

    @Column(name = "product_overview_description")
    private String productOverviewDescription;

    @Column(name = "product_catalog_unique_id", nullable = false, unique = true)
    private Integer productCatalogUniqueId;

    @Column(name = "product_catalog_quantity", nullable = false)
    private Integer productCatalogQuantity;

    @Column(name = "is_discount_available_on_catalog", nullable = false)
    private Boolean isDiscountAvailableOnCatalog = false;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    @OneToOne(mappedBy = "productCatalog", cascade = CascadeType.ALL, orphanRemoval = true)
    private ProductOverview productOverview;

    public ProductOverview getProductOverview() {
        return productOverview;
    }

    public void setProductOverview(ProductOverview productOverview) {
        this.productOverview = productOverview;
    }
}
