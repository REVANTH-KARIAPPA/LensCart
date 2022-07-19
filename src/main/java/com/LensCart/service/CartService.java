package com.LensCart.service;


import com.LensCart.Exception.UserNotFoundException;
import com.LensCart.Repository.CartRepository;
import com.LensCart.Repository.ProductRepository;
import com.LensCart.Repository.UserRepository;
import com.LensCart.entity.Cart;
import com.LensCart.entity.Product;
import com.LensCart.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

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

    public void enrollUser(int cartId, int userId) {
        Cart cart= cartRepository.findById(cartId).get();
        Users myUser= cart.getUser();
        if(myUser!=null) {

            Users users = userRepository.findById(userId).get();
            cart.setUser(users);
            cartRepository.save(cart);
            users.setCart(cart);
            userRepository.save(users);
        }
        else{
            throw new UserNotFoundException("user is already enrolled to this cart");
        }
    }

}
