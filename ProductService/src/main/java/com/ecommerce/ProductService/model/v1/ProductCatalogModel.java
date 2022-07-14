package com.ecommerce.ProductService.model.v1;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductCatalogModel {

    private Long productCatalogId;
    private String productCatalogName;
    private String productCatalogType;
    private String productOverviewDescription;
    private Integer productCatalogUniqueId;
    private Integer productCatalogQuantity;
    private Boolean isDiscountAvailableOnCatalog = false;
    private Integer productCategoryId;

}
