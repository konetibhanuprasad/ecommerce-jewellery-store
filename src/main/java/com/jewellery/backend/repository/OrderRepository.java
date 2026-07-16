package com.jewellery.backend.repository;

import com.jewellery.backend.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<Order,String> {

    List<Order> findByUserId(String userId);

}