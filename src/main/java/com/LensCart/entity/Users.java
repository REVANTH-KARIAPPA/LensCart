package com.LensCart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private String role="CUSTOMER";

    @JsonIgnore
    @OneToOne(mappedBy = "user")

    private Cart cart;

    @JsonIgnore
    @OneToMany

    private List<Orders> orders;


}
