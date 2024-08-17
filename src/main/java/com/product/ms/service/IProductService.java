package com.product.ms.service;

import com.product.ms.dto.ProductDTO;
import com.product.ms.model.ProductEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductService {

    ResponseEntity<ProductEntity> createProduct(ProductDTO productDTO);
    ResponseEntity<List<ProductEntity>> getAllProducts();
    ResponseEntity<ProductEntity> getProductById(String id);
    ResponseEntity<ProductEntity> updateProduct(String id, ProductDTO productDTO);
    ResponseEntity<String> deleteProduct(String id);
}
