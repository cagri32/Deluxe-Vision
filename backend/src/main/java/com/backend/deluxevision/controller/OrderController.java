package com.backend.deluxevision.controller;

import com.backend.deluxevision.model.CartItem;
import com.backend.deluxevision.model.Order;
import com.backend.deluxevision.model.Review;
import com.backend.deluxevision.service.OrderService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id) throws ChangeSetPersister.NotFoundException {
        Order glasses = orderService.getOrderById(id);
        return new ResponseEntity<>(glasses, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        Order newOrder = orderService.addOrder(order);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

/*
	@PutMapping("/update/{id}")
	public ResponseEntity<Glasses> updateGlasses(@RequestBody Glasses glasses, Long id) throws NotFoundException {
		Glasses newGlasses = glassesService.updateGlasses(glasses, id);
		return new ResponseEntity<>(newGlasses, HttpStatus.OK);
	}
*/

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrderById(@PathVariable("id") Long id) {
        orderService.deleteOrderById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @GetMapping("/{id}/orderItems")
//    public ResponseEntity<List<CartItem>> getCartItemsByOrderId(@PathVariable("id") Long orderId) {
//        List<CartItem> orderItems = orderService.getCartItemsByOrderId(orderId);
//        return new ResponseEntity<>(orderItems, HttpStatus.OK);
//    }
}
