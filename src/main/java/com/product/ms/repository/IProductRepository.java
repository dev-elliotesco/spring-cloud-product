package com.product.ms.repository;

import com.product.ms.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity, String> {
}
