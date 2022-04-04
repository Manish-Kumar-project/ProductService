package com.ecommerce.ProductService.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "product_overview")
public class ProductOverview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_price")
    private Double productPrice;


    @Column(name = "is_offer_available", nullable = false)
    private Boolean isOfferAvailable = false;

    @Column(name = "product_discount")
    private Double productDiscount;

    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @Column(name = "product_tax", nullable = false)
    private Double productTax;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "item_number", nullable = false)
    private String itemNumber;

    @Column(name = "product_quantity_to_buy", nullable = false)
    private Integer productQuantityToBuy;

    @Column(name = "product_brand", nullable = false)
    private String productBrand;

    @Column(name = "product_created_date")
    private Date productCreatedDate;

    @Column(name = "product_created_by")
    private String productCreatedBy;

    @Column(name = "product_upadated_date")
    private Date productUpadatedDate;

    @Column(name = "product_updated_by")
    private String productUpdatedBy;

    @Column(name = "product_unique_id", nullable = false, unique = true)
    private Long productUniqueId;

    @Column(name = "product_model_number", nullable = false)
    private Long productModelNumber;

    @Column(name = "product_model_name", nullable = false)
    private String productModelName;


    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "product_catalog_productcatalog_id")
    private ProductCatalog productCatalog;

    
}