package com.product.ms.dto;


import com.product.ms.utils.MessageUtils;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotBlank
    @NotEmpty
    @Size(min = 3, max = 50, message = MessageUtils.PRODUCT_NAME_SIZE_ERROR)
    private String name;

    @NotNull(message = MessageUtils.PRODUCT_PRICE_NULL_ERROR)
    @Min(value = 0, message = MessageUtils.PRODUCT_PRICE_MIN_ERROR)
    @Max(value = 10000, message = MessageUtils.PRODUCT_PRICE_MAX_ERROR)
    private Double price;
}
