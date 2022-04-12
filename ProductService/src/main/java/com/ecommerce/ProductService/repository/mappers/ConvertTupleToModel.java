package com.ecommerce.ProductService.repository.mappers;

import com.ecommerce.ProductService.model.v1.ProductCategoryModel;

import javax.persistence.Tuple;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ConvertTupleToModel {

    public static ProductCategoryModel convertToProductCategoryModel(Tuple tuple) {
        ProductCategoryModel productCategoryModel = new ProductCategoryModel();
        if (tuple.get("category_name") != null) {
            String categoryName = (String) tuple.get("category_name");
            productCategoryModel.setCategoryName( categoryName);
        }
        if (tuple.get("category_quantity") != null) {
            Integer quantity = (Integer) tuple.get("category_quantity");
            productCategoryModel.setCategoryQuantity(quantity.intValue());
        }
        if (tuple.get("category_unique_id") != null) {
            BigInteger productUniqueId = (BigInteger) tuple.get("category_unique_id");
            productCategoryModel.setCategoryUniqueId(productUniqueId.longValue());
        }

        return productCategoryModel;
    }
}
