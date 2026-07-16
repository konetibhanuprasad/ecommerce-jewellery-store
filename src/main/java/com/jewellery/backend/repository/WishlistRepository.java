package com.jewellery.backend.repository;

import com.jewellery.backend.entity.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WishlistRepository extends MongoRepository<Wishlist,String> {

    List<Wishlist> findByUserId(String userId);

}