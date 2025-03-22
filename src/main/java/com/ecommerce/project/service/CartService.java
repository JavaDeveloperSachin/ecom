package com.ecommerce.project.service;

import com.ecommerce.project.payload.CartDTO;
import jakarta.transaction.Transactional;

import java.util.List;


public interface CartService {
    CartDTO addProductToCart(Integer productId, Integer quantity);


    List<CartDTO> getAllCarts();

    CartDTO getCart(String email, Integer cartId);

    @Transactional
    CartDTO updateProductQuantityInCart(Integer productId, Integer quantity);

    String deleteProductFromCart(Integer cartId, Integer productId);

    void updateProductInCarts(Integer cartId, Integer productId);
}
