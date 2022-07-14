package com.ecommerce.ProductService.repository.mappers;

import com.ecommerce.ProductService.model.v1.ProductCatalogModel;
import com.ecommerce.ProductService.model.v1.ProductCategoryModel;
import com.ecommerce.ProductService.model.v1.ProductOverviewModel;

import javax.persistence.Tuple;
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
    public static ProductOverviewModel convertToProductOverviewModel(Tuple tuple) {
        ProductOverviewModel productOverviewModel = new ProductOverviewModel();
        if (tuple.get("product_name") != null) {
            String productName = (String) tuple.get("product_name");
            productOverviewModel.setProductName(productName);
        }
        if (tuple.get("product_price") != null) {
            Double productPrice = (Double) tuple.get("product_price");
            productOverviewModel.setProductPrice(productPrice.doubleValue());
        }
        if (tuple.get("product_discount") != null) {
            Double productDiscount = (Double) tuple.get("product_discount");
            productOverviewModel.setProductDiscount(productDiscount.doubleValue());
        }
        if (tuple.get("product_description") != null) {
            String productDescription = (String) tuple.get("product_description");
            productOverviewModel.setProductDescription(productDescription);
        }
        if (tuple.get("product_brand") != null) {
            String productBrand = (String) tuple.get("product_brand");
            productOverviewModel.setProductBrand(productBrand);
        }
        if (tuple.get("product_model_number") != null) {
            BigInteger productModelNumber = (BigInteger) tuple.get("product_model_number");
            productOverviewModel.setProductModelNumber(productModelNumber.longValue());
        }
        if (tuple.get("product_model_name") != null) {
            String productModelName = (String) tuple.get("product_model_name");
            productOverviewModel.setProductBrand(productModelName);
        }

        return productOverviewModel;
    }
    }


