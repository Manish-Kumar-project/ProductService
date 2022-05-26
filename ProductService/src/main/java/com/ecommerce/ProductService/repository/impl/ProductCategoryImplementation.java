package com.ecommerce.ProductService.repository.impl;

import com.ecommerce.ProductService.entities.ProductCategory;
import com.ecommerce.ProductService.model.v1.ProductCatalogModel;
import com.ecommerce.ProductService.model.v1.ProductCategoryModel;
import com.ecommerce.ProductService.repository.mappers.ConvertTupleToModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductCategoryImplementation {

    @Autowired
    private EntityManager entityManager;

    public List<ProductCategoryModel> getProductCategoriesList() {
        List<Tuple> tuples = new ArrayList<>();

        StringBuilder selectQuery = new StringBuilder();
        StringBuilder fromQuery = new StringBuilder();
        StringBuilder whereQuery = new StringBuilder();

        selectQuery.append("select category.category_name,");
        selectQuery.append("category.category_quantity,");
        selectQuery.append("category.category_unique_id");
        fromQuery.append(" from testdb.product_category category");


        Query query = entityManager.createNativeQuery(selectQuery.toString()
                .concat(fromQuery.toString()
                        .concat(whereQuery.toString())), Tuple.class);
        tuples = (List<Tuple>) query.getResultList();
        List<ProductCategoryModel> productCategoryModels = tuples.stream().map(ConvertTupleToModel::convertToProductCategoryModel).collect(Collectors.toList());
        return productCategoryModels;
    }
    public List<ProductCatalogModel> getProductCatalogList() {
        List<Tuple> tuples = new ArrayList<>();

        StringBuilder selectQuery = new StringBuilder();
        StringBuilder fromQuery = new StringBuilder();
        StringBuilder whereQuery = new StringBuilder();

        selectQuery.append("select catalog.is_discount_available_on_catalog,");
        selectQuery.append("catalog.product_catalog_name,");
        selectQuery.append("catalog.product_catalog_type,");
        selectQuery.append("catalog.product_catalog_quantity,");
        selectQuery.append("catalog.product_catalog_unique_id,");
        selectQuery.append("catalog.product_overview_description,");
        selectQuery.append("catalog.product_category_id");
        fromQuery.append(" from testdb.product_catalog catalog");


        Query query = entityManager.createNativeQuery(selectQuery.toString()
                .concat(fromQuery.toString()
                        .concat(whereQuery.toString())), Tuple.class);
        tuples = (List<Tuple>) query.getResultList();
        List<ProductCatalogModel> productCatalogModels = tuples.stream().map(ConvertTupleToModel::convertToProductCatalogModel).collect(Collectors.toList());
        return productCatalogModels;
    }
}