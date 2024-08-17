package com.product.ms.controller;

import com.product.ms.controller.docs.ProductDoc;
import com.product.ms.dto.ProductDTO;
import com.product.ms.model.ProductEntity;
import com.product.ms.service.IProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController implements ProductDoc {

    private final IProductService productService;

    @Override
    @PostMapping
    public ResponseEntity<ProductEntity> createUser(ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable String id, ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) {
        return productService.deleteProduct(id);
    }
}
