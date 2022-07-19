package com.LensCart.controller;

import com.LensCart.entity.Users;
import com.LensCart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;


    @GetMapping("/all")
    public List<Users> getAllUsers(){

        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable int id){
        Users users=userService.getUserById(id);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @PostMapping("/create")
    public void createUser(@RequestBody Users user){
        userService.createUser(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
    }

}
