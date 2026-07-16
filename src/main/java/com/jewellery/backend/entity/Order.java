package com.jewellery.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String userId;

    private String productId;

    private int quantity;

    private double totalPrice;

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    private String status;

    private Date orderDate;

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Order() {}
    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }



    public Order(String id, String userId, String productId,
                 int quantity, double totalPrice,
                 String status, Date orderDate) {


        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.status = status;
        this.orderDate = orderDate;
    }

    // Generate Getters & Setters in IntelliJ
}