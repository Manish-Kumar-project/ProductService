package com.ecommerce.ProductService.repository;

import com.ecommerce.ProductService.entities.ProductCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Long> {
     ProductCatalog findByProductCatalogUniqueId(Integer productCatalogUniqueId);

}