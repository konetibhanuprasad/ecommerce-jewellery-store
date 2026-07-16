package com.jewellery.backend.service;

import com.jewellery.backend.entity.Order;
import com.jewellery.backend.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(Order order){

        order.setStatus("PLACED");
        order.setOrderDate(new Date());

        return orderRepository.save(order);
    }

    public List<Order> getOrders(String userId){

        return orderRepository.findByUserId(userId);
    }

}