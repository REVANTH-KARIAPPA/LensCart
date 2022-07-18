package com.LensCart.service;

import com.LensCart.Repository.OrderRepository;
import com.LensCart.Repository.ProductRepository;
import com.LensCart.Repository.UserRepository;
import com.LensCart.entity.Orders;
import com.LensCart.entity.Product;
import com.LensCart.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    public void addOrder(Orders orders){
        orderRepository.save(orders);
    }
    public List<Orders> getAllOrders(){
        return orderRepository.findAll();
    }
    public  void deleteOrder(int id){
        orderRepository.deleteById(id);
    }

    public void placeOrder(int orderId, int productId) {
        Orders orders= orderRepository.findById(orderId).get();
        Product product= productRepository.findById(productId).get();
        orders.putProduct(product);
        orderRepository.save(orders);
    }

    public void addUser(int orderId, int userId) {
        Orders orders= orderRepository.findById(orderId).get();
        Users users= userRepository.findById(userId).get();
        orders.setUsers(users);
        orderRepository.save(orders);
    }
}
