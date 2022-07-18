package com.LensCart.controller;


import com.LensCart.entity.Orders;
import com.LensCart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/all")
    public List<Orders> getAllOrders() {

        return orderService.getAllOrders();

    }
    @PostMapping("/create")
    public void addOrders(@RequestBody Orders order){
        orderService.addOrder(order);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id){
        orderService.deleteOrder(id);
    }

    @PutMapping("/{orderId}/product/{productId}")
    public void addProduct(@PathVariable int orderId, @PathVariable int productId){
        orderService.placeOrder(orderId,productId);

    }
    @PutMapping("/{orderId}/user/{userId}")
    public void addUser(@PathVariable int orderId, @PathVariable int userId){
        orderService.addUser(orderId,userId);

    }



}
