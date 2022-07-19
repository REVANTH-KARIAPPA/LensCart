package com.LensCart.service;

import com.LensCart.Exception.ProductNotFoundException;
import com.LensCart.Repository.CategoryRepository;
import com.LensCart.Repository.ProductRepository;
import com.LensCart.entity.Category;
import com.LensCart.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;

    public void addCategory(Category category){
        categoryRepository.save(category);
    }
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    public  void deleteCategory(int id){
        Optional<Category> category = categoryRepository.findById(id);
        if(category.isPresent()){
             categoryRepository.deleteById(id);
        }
        else {
            throw new ProductNotFoundException("Product with productId "+id+" is not found");
        }
    }

    public void enrollCategory(int categoryId, int productId) {
        Category category= categoryRepository.findById(categoryId).get();
        Product product= productRepository.findById(productId).get();
        product.setCategory(category);
        categoryRepository.save(category);
        productRepository.save(product);
    }
}
