package com.LensCart.service;

import com.LensCart.Exception.ProductNotFoundException;
import com.LensCart.Repository.ProductRepository;
import com.LensCart.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void createProduct(Product product){
        productRepository.save(product);
    }
    public void updateProduct(Product product, int id){
        Product optionalProduct= getProductById(id);
        Product myProduct=optionalProduct;
        if(myProduct!=null) {
            myProduct.setProductName(product.getProductName());
            myProduct.setPrize(product.getPrize());
        }
        productRepository.save(myProduct);
    }
    public void deleteProduct(int id)
    {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            productRepository.deleteById(id);
        }
        else {
            throw new ProductNotFoundException("Product with productId "+id+"\n is not found");
        }
    }
    public ArrayList<Product> getAllProducts(){
        return new ArrayList<>(productRepository.findAll());
    }
    public Product getProductById(int id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
            return productRepository.findById(id).get();
        }
        else {
            throw new ProductNotFoundException("Product with productId "+id+" is not found");
        }
    }

}
