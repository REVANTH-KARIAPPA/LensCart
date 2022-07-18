package com.LensCart.service;


import com.LensCart.Repository.CartRepository;
import com.LensCart.Repository.ProductRepository;
import com.LensCart.entity.Cart;
import com.LensCart.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;

    public void addCart(Cart cart){
        cartRepository.save(cart);
    }
    public List<Cart> getAllCart(){
        return cartRepository.findAll();
    }
    public  void deleteCart(int id){
        cartRepository.deleteById(id);
    }

    public void enrollCart(int cartId, int productId) {
        Cart cart= cartRepository.findById(cartId).get();
        Product product= productRepository.findById(productId).get();
        product.addCart(cart);
        cart.addProducts(product);
        cartRepository.save(cart);
        productRepository.save(product);
    }
}
