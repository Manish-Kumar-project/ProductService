package com.ecommerce.ProductService.repository;

import com.ecommerce.ProductService.entities.ProductOverview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOverviewRepository extends JpaRepository<ProductOverview, Long> {
}