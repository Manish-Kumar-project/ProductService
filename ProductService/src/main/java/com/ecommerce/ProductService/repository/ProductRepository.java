package com.ecommerce.ProductService.repository;

import com.ecommerce.ProductService.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface ProductRepository extends JpaRepository<Product, CriteriaBuilder.In> {
}
