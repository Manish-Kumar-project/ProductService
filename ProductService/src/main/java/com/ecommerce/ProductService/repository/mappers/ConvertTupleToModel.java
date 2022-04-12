package com.ecommerce.ProductService.repository.mappers;

import com.ecommerce.ProductService.model.v1.ProductCatalogModel;
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
    public static ProductCatalogModel convertToProductCatalogModel(Tuple tuple) {
        ProductCatalogModel productCatalogModel = new ProductCatalogModel();
        if (tuple.get("is_discount_available_on_catalog") != null) {
            Boolean isDiscountAvailable = (Boolean) tuple.get("is_discount_available_on_catalog");
            productCatalogModel.setIsDiscountAvailableOnCatalog(isDiscountAvailable);
        }
        if (tuple.get("product_catalog_name") != null) {
            String catalogName = (String) tuple.get("product_catalog_name");
            productCatalogModel.setProductCatalogName( catalogName);
        }
        if (tuple.get("product_catalog_quantity") != null) {
            Integer quantity = (Integer) tuple.get("product_catalog_quantity");
            productCatalogModel.setProductCatalogQuantity(quantity.intValue());
        }
        if (tuple.get("product_catalog_type") != null) {
            String productCatalogType = (String) tuple.get("product_catalog_type");
            productCatalogModel.setProductCatalogType(productCatalogType);
        }
        if (tuple.get("product_catalog_unique_id") != null) {
            Integer catalogUniqueId = (Integer) tuple.get("product_catalog_unique_id");
            productCatalogModel.setProductCatalogUniqueId(catalogUniqueId.intValue());
        }
        if (tuple.get("product_overview_description") != null) {
            String productOverviewDescription = (String) tuple.get("product_overview_description");
            productCatalogModel.setProductOverviewDescription(productOverviewDescription);
        }
        if (tuple.get("product_category_id") != null) {
            BigInteger productCategoryId = (BigInteger) tuple.get("product_category_id");
            productCatalogModel.setProductCategoryId(productCategoryId.intValue());
        }
        return productCatalogModel;
    }
}
