package com.backend.deluxevision.service;

import com.backend.deluxevision.model.CartItem;
import com.backend.deluxevision.model.Review;
import com.backend.deluxevision.repo.OrderRepo;
import com.backend.deluxevision.model.Order;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public Order addOrder(Order order) {
        return orderRepo.save(order);
    }


    @Transactional
    public void deleteOrderById(Long orderId) {
        orderRepo.deleteByOrderId(orderId);
    }
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }


    public Order getOrderById(Long orderId) throws ChangeSetPersister.NotFoundException {
        /*
         * return glassesRepo.findGlassesById(id) .orElseThrow(() -> new
         * GlassesNotFoundException("Glasses by id " + id + " was not found"));
         */
        Optional<Order> orderOptional = orderRepo.getOrderByOrderId(orderId);
        Order order = orderOptional.orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        return order;

    }

//    public List<CartItem> getCartItemsByOrderId(Long orderId) {
//        return orderRepo.getCartItemsByOrderId(orderId);
//    }
}
