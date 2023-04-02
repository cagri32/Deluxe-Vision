package com.backend.deluxevision.service;

import com.backend.deluxevision.model.CartItem;
import com.backend.deluxevision.repo.CartItemRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {

    private final CartItemRepo cartItemRepo;

    @Autowired
    public CartItemService(CartItemRepo cartItemRepo) {
        this.cartItemRepo = cartItemRepo;
    }

    public CartItem addCartItem(CartItem cartItem) {
        return cartItemRepo.save(cartItem);
    }

    @Transactional
    public void deleteCartItemByCartItemId(Long id) {
        cartItemRepo.deleteCartItemByCartItemId(id);
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepo.findAll();
    }

}
