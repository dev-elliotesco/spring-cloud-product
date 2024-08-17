package com.product.ms.service.imp;

import com.product.ms.dto.ProductDTO;
import com.product.ms.exception.ProductException;
import com.product.ms.model.ProductEntity;
import com.product.ms.repository.IProductRepository;
import com.product.ms.service.IProductService;
import com.product.ms.utils.MessageUtils;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository iProductRepository;

    @Override
    public ResponseEntity<ProductEntity> createProduct(ProductDTO productDTO) {

        ProductEntity productEntity = toEntity(productDTO);
        iProductRepository.save(productEntity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productEntity);
    }

    @Override
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> products = iProductRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @Override
    public ResponseEntity<ProductEntity> getProductById(String id) {
        ProductEntity product = iProductRepository.findById(id)
                .orElseThrow(() -> new ProductException(MessageUtils.PRODUCT_NOT_FOUND + id));
        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<ProductEntity> updateProduct(String id, ProductDTO productDTO) {
        ProductEntity product = iProductRepository.findById(id)
                .orElseThrow(() -> new ProductException(MessageUtils.PRODUCT_NOT_FOUND + id));

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        iProductRepository.save(product);
        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<String> deleteProduct(String id) {
        if (!iProductRepository.existsById(id)) {
            throw new ProductException(MessageUtils.PRODUCT_NOT_FOUND + id);
        }
        iProductRepository.deleteById(id);
        return ResponseEntity.ok(MessageUtils.PRODUCT_DELETED);
    }

    private ProductEntity toEntity(ProductDTO productDTO) {
        return ProductEntity.builder()
                .id(UUID.randomUUID().toString())
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .build();
    }
}
