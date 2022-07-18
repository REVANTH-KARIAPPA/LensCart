package com.LensCart.entity;

import lombok.Data;


import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @ManyToMany
    @JoinTable(name ="ordered_products",
            joinColumns = @JoinColumn(name = "orders_id"),
            inverseJoinColumns = @JoinColumn(name = "product_productId"))
    private List<Product> products;

    @ManyToOne
    private Users users;


    public void putProduct(Product product) {
        products.add(product);
    }
}
