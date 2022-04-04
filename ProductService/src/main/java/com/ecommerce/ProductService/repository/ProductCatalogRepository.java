package com.ecommerce.ProductService.repository;

import com.ecommerce.ProductService.entities.ProductCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface ProductCatalogRepository extends JpaRepository<ProductCatalog, Long> {
}