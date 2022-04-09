package com.ecommerce.ProductService.model.v1;

import lombok.*;


import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ProductCategoryModel implements Serializable {

    private Long categoryUniqueId;
    private String categoryName;
    private Integer categoryQuantity;
}
