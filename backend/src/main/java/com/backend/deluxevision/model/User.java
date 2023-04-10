package com.backend.deluxevision.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class User implements Serializable {

    public User() {
        // Default constructor
    }

    public User(String userName, String email, String role, String billingAddress, String mailingAddress,String password) {
        this.userName = userName;
        this.email = email;
        this.role = role;
        this.billingAddress = billingAddress;
        this.mailingAddress = mailingAddress;
        this.password = password;
    }

    @Id
    @Column(nullable = false, updatable = false)
    private String userName;
    private String email;
    private String role;
    private String billingAddress;
    private String mailingAddress;
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", mailingAddress='" + mailingAddress + '\'' +
                '}';
    }
}
