package com.backend.deluxevision.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class CartItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long cartItemId;
    private Long orderId;
    private Long glassesId;
    private int quantity;
    private Double price;

    public CartItem() {
        // Default constructor
    }

    public CartItem(Long cartItemId, Long orderId, Long glassesId, int quantity, Double price) {
        this.cartItemId = cartItemId;
        this.orderId = orderId;
        this.glassesId = glassesId;
        this.quantity = quantity;
        this.price = price;
    }

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getGlassesId() {
        return glassesId;
    }

    public void setGlassesId(Long glassesId) {
        this.glassesId = glassesId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartItemId=" + cartItemId +
                ", orderId=" + orderId +
                ", glassesId=" + glassesId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
