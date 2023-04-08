package com.backend.deluxevision.repo;
import com.backend.deluxevision.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.deluxevision.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order, Long>{

    void deleteByOrderId(Long orderId);
    Optional<Order> getOrderByOrderId(Long orderId);
//    List<CartItem> getCartItemsByOrderId(Long orderId);

//    @Query(value = "SELECT NEW com.backend.deluxevision.model.CartItem(c.glassesId, c.quantity, c.price) FROM Orders c WHERE c.orderId = :orderId")
//    List<CartItem> getCartItemsByOrderId(@Param("orderId") Long orderId);

}
