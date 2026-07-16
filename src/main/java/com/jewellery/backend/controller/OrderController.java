package com.jewellery.backend.controller;

import com.jewellery.backend.entity.Order;
import com.jewellery.backend.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order placeOrder(@RequestBody Order order){

        return orderService.placeOrder(order);
    }

    @GetMapping("/{userId}")
    public List<Order> getOrders(@PathVariable String userId){

        return orderService.getOrders(userId);
    }

}