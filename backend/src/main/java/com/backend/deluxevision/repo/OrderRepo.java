package com.backend.deluxevision.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.deluxevision.model.Order;

import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order, Long>{

    void deleteByOrderId(Long orderId);
    Optional<Order> getOrderByOrderId(Long orderId);

}
