package com.backend.deluxevision.repo;
import com.backend.deluxevision.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepo extends JpaRepository<CartItem, Long>{

    void deleteCartItemByCartItemId(Long cartItemId);

}
