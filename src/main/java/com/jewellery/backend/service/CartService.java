package com.jewellery.backend.service;

import com.jewellery.backend.entity.Cart;
import com.jewellery.backend.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart addToCart(Cart cart){

        return cartRepository.save(cart);
    }

    public List<Cart> getCart(String userId){

        return cartRepository.findByUserId(userId);
    }

    public String deleteCartItem(String id){

        cartRepository.deleteById(id);

        return "Item Removed Successfully";
    }

}