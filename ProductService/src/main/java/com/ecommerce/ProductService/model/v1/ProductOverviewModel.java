package com.ecommerce.ProductService.model.v1;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductOverviewModel implements Serializable {

    private String productName;
    private Double productPrice;
    private Boolean isOfferAvailable = false;
    private Double productDiscount;
    private String productDescription;
    private Double productTax;
    private String imageUrl;
    private String itemNumber;
    private Integer productQuantityToBuy;
    private String productBrand;
    private Date productCreatedDate;
    private String productCreatedBy;
    private Date productUpdatedDate;
    private String productUpdatedBy;
    private Long productUniqueId;
    private Long productModelNumber;
    private String productModelName;


}
