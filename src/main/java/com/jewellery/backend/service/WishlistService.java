package com.jewellery.backend.service;

import com.jewellery.backend.entity.Wishlist;
import com.jewellery.backend.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public Wishlist addWishlist(Wishlist wishlist){

        return wishlistRepository.save(wishlist);
    }

    public List<Wishlist> getWishlist(String userId){

        return wishlistRepository.findByUserId(userId);
    }

    public String deleteWishlist(String id){

        wishlistRepository.deleteById(id);

        return "Wishlist Item Deleted";
    }

}