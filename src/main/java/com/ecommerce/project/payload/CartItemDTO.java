package com.ecommerce.project.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private Integer cartItemId;
    private ProductDTO productDTO;
    private CartDTO cart;
    private Integer quantity;
    private Double discount;
    private Double productPrice;

}
