package com.ecommerce.ProductService.model.v1;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductCatalogModel implements Serializable {

    private String productCatalogName;
    private String productCatalogType;
    private String productOverviewDescription;
    private Integer productCatalogUniqueId;
    private Integer productCatalogQuantity;
    private Boolean isDiscountAvailableOnCatalog = false;

}
