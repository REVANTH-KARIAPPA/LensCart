package com.LensCart.controller;

import java.util.List;


import com.LensCart.entity.Product;
import com.LensCart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }
    @GetMapping("/{pid}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer pid)
    {
        Product product=productService.getProductById(pid);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }




}