package com.LensCart.Exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException (String message){
        super(message);
    }
}
