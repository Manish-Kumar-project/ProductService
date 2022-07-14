package com.ecommerce.ProductService.repository.impl;

import com.ecommerce.ProductService.model.v1.ProductCatalogModel;
import com.ecommerce.ProductService.model.v1.ProductCategoryModel;
import com.ecommerce.ProductService.model.v1.ProductOverviewModel;
import com.ecommerce.ProductService.repository.mappers.ConvertTupleToModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.transaction.Transactional;
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
    public ProductOverviewModel getProductOverview(Integer productDetailId) {
        List<Tuple> tuples = new ArrayList<>();

        StringBuilder selectQuery = new StringBuilder();
        StringBuilder fromQuery = new StringBuilder();
        StringBuilder whereQuery = new StringBuilder();

        selectQuery.append("select product.product_name,");
        selectQuery.append("product.product_price,");
//        selectQuery.append("product.is_offer_available,");
        selectQuery.append("product.product_discount,");
        selectQuery.append("product.product_description,");
//        selectQuery.append("product.product_tax,");
//        selectQuery.append("product.image_url,");
//        selectQuery.append("product.product_quantity_to_buy,");
        selectQuery.append("product.product_brand,");
        selectQuery.append("product.product_model_number,");
        selectQuery.append("product.product_model_name");

        fromQuery.append(" from testdb.product_overview product");
        whereQuery.append(" where product.product_catalog_productcatalog_id ='" + productDetailId+"'");


        Query query = entityManager.createNativeQuery(selectQuery.toString()
                .concat(fromQuery.toString()
                        .concat(whereQuery.toString())), Tuple.class);
        tuples = (List<Tuple>) query.getResultList();
        List<ProductOverviewModel> productOverviewModel = tuples.stream().map(ConvertTupleToModel::convertToProductOverviewModel).collect(Collectors.toList());

        return productOverviewModel.get(0);
    }
    

    @Transactional
    public void updateProductsQuantity(Integer productQuantity,Integer productCatalogUniqueId){
      //  ProductCatalog productCatalogModelFromDB = productCatalogRepository.findByProductCatalogUniqueId(productCatalogModel.getProductCatalogUniqueId());
        //Integer productUpdateQuantity = productCatalogModelFromDB.getProductCatalogQuantity()-productCatalogModel.getProductCatalogQuantity();
            StringBuilder updateQuery = new StringBuilder();
            try {
                updateQuery.append("update  testdb.product_catalog productcatalog set");
                updateQuery.append(" productcatalog.product_catalog_quantity = '" + productQuantity+"'");
                updateQuery.append(" where  productcatalog.product_catalog_unique_id = '" + productCatalogUniqueId+"'");
                entityManager.createNativeQuery(updateQuery.toString()).executeUpdate();
            } catch (Exception exception) {
                System.out.println("Exception occured : " + exception.getStackTrace());
            }


    }
}
