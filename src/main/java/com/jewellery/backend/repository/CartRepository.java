package com.jewellery.backend.repository;

import com.jewellery.backend.entity.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends MongoRepository<Cart,String> {

    List<Cart> findByUserId(String userId);

    Optional<Cart> findByUserIdAndProductId(String userId,String productId);
}