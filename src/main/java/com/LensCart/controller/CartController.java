package com.LensCart.controller;

import com.LensCart.entity.Cart;

import com.LensCart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/all")
    public List<Cart> getAllCart() {

        return cartService.getAllCart();

    }
    @PostMapping("/create")
    public void addCategory(@RequestBody Cart cart){
        cartService.addCart(cart);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id){
        cartService.deleteCart(id);
    }

    @PutMapping("/{cartId}/product/{productId}")
    public void enrollCategory(@PathVariable int cartId, @PathVariable int productId){
        cartService.enrollCart(cartId,productId);

    }

}
