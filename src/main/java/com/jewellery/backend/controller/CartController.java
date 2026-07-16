package com.jewellery.backend.controller;

import com.jewellery.backend.entity.Cart;
import com.jewellery.backend.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public Cart addToCart(@RequestBody Cart cart){

        return cartService.addToCart(cart);
    }

    @GetMapping("/{userId}")
    public List<Cart> getCart(@PathVariable String userId){

        return cartService.getCart(userId);
    }

    @DeleteMapping("/{id}")
    public String deleteCartItem(@PathVariable String id){

        return cartService.deleteCartItem(id);
    }

}