package com.product.ms.service.imp;

import com.product.ms.dto.ProductDTO;
import com.product.ms.model.ProductEntity;
import com.product.ms.repository.IProductRepository;
import com.product.ms.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository iProductRepository;

    @Override
    public ResponseEntity<ProductEntity> createProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return null;
    }

    @Override
    public ResponseEntity<ProductEntity> getProductById(String id) {
        return null;
    }

    @Override
    public ResponseEntity<ProductEntity> updateProduct(String id, ProductDTO productDTO) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteProduct(String id) {
        return null;
    }
}
