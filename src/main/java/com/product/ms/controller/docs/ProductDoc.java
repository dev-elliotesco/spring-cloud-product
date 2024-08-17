package com.product.ms.controller.docs;

import com.product.ms.dto.ProductDTO;
import com.product.ms.model.ProductEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Product controller", description = "API exposed to manage products")
public interface ProductDoc {
    @Operation(summary = "Create product", description = "This operation is for create a product")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Product created",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<ProductEntity> createUser(@RequestBody @Valid ProductDTO productDTO);

    @Operation(summary = "Get all products", description = "This operation is for get all products")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Products found",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "No products found",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<List<ProductEntity>> getAllProducts();

    @Operation(summary = "Get product by id", description = "This operation is for get a product by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Product found",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Product not found",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<ProductEntity> getProductById(@PathVariable String id);

    @Operation(summary = "Update product", description = "This operation is for update a product")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Product updated",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Product not found",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<ProductEntity> updateProduct(@PathVariable String id, @RequestBody @Valid ProductDTO productDTO);

    @Operation(summary = "Delete product", description = "This operation is for delete a product")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Product deleted",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Product not found",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error",
                    content = @Content(mediaType = "application/json")
            )
    })
    public ResponseEntity<String> deleteProduct(@PathVariable String id);

}
