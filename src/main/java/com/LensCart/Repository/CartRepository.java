package com.LensCart.Repository;

import com.LensCart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Integer> {

}