package com.jewellery.backend.controller;

import com.jewellery.backend.entity.Wishlist;
import com.jewellery.backend.service.WishlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @PostMapping
    public Wishlist addWishlist(@RequestBody Wishlist wishlist){

        return wishlistService.addWishlist(wishlist);
    }

    @GetMapping("/{userId}")
    public List<Wishlist> getWishlist(@PathVariable String userId){

        return wishlistService.getWishlist(userId);
    }

    @DeleteMapping("/{id}")
    public String deleteWishlist(@PathVariable String id){

        return wishlistService.deleteWishlist(id);
    }

}