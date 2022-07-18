package com.LensCart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer categoryId;
    private String categoryName;


    @OneToMany(mappedBy = "category")
    private List<Product> products;





}
