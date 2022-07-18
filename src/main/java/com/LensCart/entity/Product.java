package com.LensCart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer productId;
    private String productName;
    private String prize;


    @ManyToOne()
    @JoinColumn(name = "category_id",referencedColumnName = "categoryId")
    private Category category;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Cart> carts;

    @JsonIgnore
    @ManyToMany(mappedBy = "products")
    private List<Orders> orders;


    public void addCart( Cart cart) {
        carts.add(cart);
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
